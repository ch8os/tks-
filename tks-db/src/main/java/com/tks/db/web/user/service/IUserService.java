package com.tks.db.web.user.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRecordInfo;
import com.tks.resource.common.entity.LoginUserInfo;
import com.tks.resource.common.entity.userInfo.DeptAndRoleInfoResponse;
import com.tks.resource.common.entity.userInfo.UserAddOrUpdateParams;
import com.tks.resource.common.entity.userInfo.UserParam;
import com.tks.resource.common.entity.userInfo.UserSearchResult;

/**
 * @ Purpose:
 * @Package Name: com.tks.db.web.user.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
public interface IUserService {
    LoginUserInfo doLogin(LoginUserInfo loginUserInfo);


    /**
     * @param userKey
     */
    public String getLoginToken(String userKey);

    String doLogout(String token);

    List<BRecordInfo> getRecentOperations(String userId,String hosCode);

    List<BMenuInfo> getUserMenuInfo(String roleId);

    List<BMenuInfo> getMenuByPage(int pageSize,int pageNum);

    PageInfo<UserSearchResult> getUserInfoByCondition(UserParam userParam, int pageSize, int pageNum);

    DeptAndRoleInfoResponse getDeptAndRoleInfo( String hosCode);

    UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams);

    int changUserStateById(String userId);

    int resetPassword(String userId);
}
