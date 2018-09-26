package com.tks.web.feigns;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tks.resource.common.entity.LoginUserInfo;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.userInfo.DeptAndRoleInfoResponse;
import com.tks.resource.common.entity.userInfo.UserAddOrUpdateParams;
import com.tks.resource.common.entity.userInfo.UserConditionParam;
import com.tks.resource.common.entity.userInfo.UserSearchResult;
import com.tks.web.feigns.hystric.UserFeignHystric;
import com.github.pagehelper.PageInfo;

/**
 * @ Purpose: 用户服务类FeignsClient
 * @Package Name: com.dpm.unity.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
@FeignClient(value = "tks-db", fallback = UserFeignHystric.class)
public interface IUserFeignClient {
    /**
     * 获取用户长令牌
     *
     * @param userKey
     * @return
     */
    @RequestMapping("/user/getLoginToken")
    String getLoginToken(@RequestParam(value = "userKey") String userKey);

    /**
     * 用户登录
     *
     * @param loginUserInfo
     * @return
     */
    @RequestMapping(value = "/user/doLogin", method = RequestMethod.POST)
    LoginUserInfo doLogin(@RequestBody LoginUserInfo loginUserInfo);

    /**
     * @param
     * @return
     */
    @RequestMapping(value = "/user/doLogout", method = RequestMethod.POST)
    String doLogout(@RequestParam(value = "token") String token);

    @RequestMapping(value = "/user/getUserMenuInfo", method = RequestMethod.GET)
    List<BMenuInfo> getUserMenuInfo(@RequestParam(value = "roleId") String roleId);

    @RequestMapping("/user/getUserInfoByCondition")
    PageInfo<UserSearchResult> getUserInfoByCondition(@RequestBody UserConditionParam userConditionParam);

    @RequestMapping("/user/getDeptAndRoleInfo")
    DeptAndRoleInfoResponse getDeptAndRoleInfo(@RequestParam(value = "hosCode") String hosCode);

    @RequestMapping("/user/saveOrUpdateUserInfo")
    UserAddOrUpdateParams saveOrUpdateUserInfo(@RequestBody UserAddOrUpdateParams userAddOrUpdateParams);

    @RequestMapping(value = "/user/changUserStateById",method = RequestMethod.GET)
    int changUserStateById(@RequestParam(value = "userId")String userId);

    @RequestMapping(value = "/user/resetPassword",method = RequestMethod.GET)
    int resetPassword(@RequestParam(value = "userId")String userId);
}
