package com.tks.web.login.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BUserInfo;
import com.tks.resource.common.entity.LoginUserInfo;
import com.tks.resource.common.utils.UUIDUtils;
import com.tks.web.common.token.JwtTokenService;
import com.tks.web.feigns.IUserFeignClient;
import com.tks.web.login.pojo.LoginUserResult;
import com.tks.web.login.pojo.UserKey;
import com.tks.web.login.pojo.UserMenu;
import com.tks.web.login.service.ILoginService;

import sun.misc.BASE64Encoder;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    JwtTokenService jwtTokenService;
    @Autowired
    IUserFeignClient userFeignClient;
    private static final String CHARSET = "utf-8";

    @Override
    public String getRefreshToken(String token) {
        return userFeignClient.getLoginToken(jwtTokenService.getTokenUserKey(token));
    }

    @Override
    public LoginUserResult doLogin(String userCode, String password) throws Exception {
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        UserKey userKey = new UserKey();
        userKey.setPrefix(UUIDUtils.getUUID());//每次登录都标记为新设备
        userKey.setUserCode(userCode);
        userKey.setPassword(DigestUtils.md5Hex(password));

        JSONObject claims = new JSONObject();
        String userKeyString = new BASE64Encoder().encode(JSON.toJSONString(userKey).getBytes(CHARSET));
        claims.put("userkey", userKeyString);

        loginUserInfo.setToken(jwtTokenService.createToken(claims));
        loginUserInfo.setAutoLogin(false);
        BUserInfo userInfo = new BUserInfo();
        userInfo.setUserCode(userCode);
        userInfo.setPassword(userKey.getPassword());
        loginUserInfo.setUserInfo(userInfo);
        //获取用户登录信息
        LoginUserInfo loginUser = userFeignClient.doLogin(loginUserInfo);
        //获取用户角色菜单
        List<UserMenu> userMenus = getUserMenuByRoleId(loginUser.getUserInfo().getRoleId());

        LoginUserResult loginUserResult = new LoginUserResult();
        loginUserResult.setToken(loginUserInfo.getToken());
        loginUserResult.setUserInfo(loginUser.getUserInfo());
        loginUserResult.setUserDepts(loginUser.getUserDeptList());
        loginUserResult.setUserMenus(userMenus);
        return loginUserResult;
    }

    @Override
    public void doLogout(String token) {
        userFeignClient.doLogout(token);
    }

    private static final String ROOT_LEVEL = "0";

    @Override
    public List<UserMenu> getUserMenuByRoleId(String roleId) {
        List<BMenuInfo> menuInfo = userFeignClient.getUserMenuInfo(roleId);
        List<UserMenu> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(menuInfo)) {
            List<BMenuInfo> rootMenuList = menuInfo.stream().filter(k -> ROOT_LEVEL.equals(k.getLevel())).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(rootMenuList)) {
                rootMenuList.stream().forEach(kk -> {
                    UserMenu userMenu = new UserMenu();
                    userMenu.setName(kk.getName());
                    userMenu.setComponent(kk.getUrl());
                    userMenu.setPath(kk.getPath());
                    List<UserMenu> childList = new ArrayList<>();
                    List<BMenuInfo> menuInfos = menuInfo.stream().filter(s -> "1".equals(s.getLevel()) && s.getParentCode().equals(kk.getMenuCode())).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(menuInfos)) {
                        menuInfos.stream().forEach(tt -> {
                            UserMenu child = new UserMenu();
                            child.setName(tt.getName());
                            child.setComponent(tt.getUrl());
                            child.setPath(tt.getPath());
                            childList.add(child);
                        });
                    }
                    userMenu.setChildren(childList);
                    result.add(userMenu);
                });
            }
        }
        return result;
    }
}
