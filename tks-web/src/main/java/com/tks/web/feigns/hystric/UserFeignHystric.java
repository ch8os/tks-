package com.tks.web.feigns.hystric;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.LoginUserInfo;
import com.tks.resource.common.entity.userInfo.DeptAndRoleInfoResponse;
import com.tks.resource.common.entity.userInfo.UserAddOrUpdateParams;
import com.tks.resource.common.entity.userInfo.UserConditionParam;
import com.tks.resource.common.entity.userInfo.UserSearchResult;
import com.tks.web.feigns.IUserFeignClient;

/**
 * @ Purpose:
 * @Package Name: com.dpm.unity.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/15
 */
public class UserFeignHystric implements IUserFeignClient {
    @Override
    public String getLoginToken(String userKey) {
        return null;
    }

    @Override
    public LoginUserInfo doLogin(LoginUserInfo loginUserInfo) {
        return null;
    }

    @Override
    public String doLogout(String token) {
        return null;
    }

    @Override
    public List<BMenuInfo> getUserMenuInfo(String roleId) {
        return null;
    }

    @Override
    public PageInfo<UserSearchResult> getUserInfoByCondition(UserConditionParam userConditionParam) {
        return null;
    }

    @Override
    public DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode) {
        return null;
    }

    @Override
    public UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams) {
        return null;
    }

    @Override
    public int changUserStateById(String userId) {
        return 0;
    }

    @Override
    public int resetPassword(String userId) {
        return 0;
    }
}
