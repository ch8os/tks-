package com.tks.wx.login.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tks.resource.common.entity.BUserInfo;
import com.tks.resource.common.entity.LoginUserInfo;
import com.tks.resource.common.utils.UUIDUtils;
import com.tks.wx.common.token.JwtTokenService;
import com.tks.wx.feigns.IUserFeignClient;
import com.tks.wx.login.pojo.LoginUserResult;
import com.tks.wx.login.pojo.UserKey;
import com.tks.wx.login.service.ILoginService;

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

        LoginUserResult loginUserResult = new LoginUserResult();
        loginUserResult.setToken(loginUserInfo.getToken());
        loginUserResult.setUserInfo(loginUser.getUserInfo());
        loginUserResult.setUserDepts(loginUser.getUserDeptList());
        return loginUserResult;
    }

    @Override
    public void doLogout(String token) {
        userFeignClient.doLogout(token);
    }


}
