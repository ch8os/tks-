package com.tks.web.user.service;


import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.userInfo.DeptAndRoleInfoResponse;
import com.tks.resource.common.entity.userInfo.UserAddOrUpdateParams;
import com.tks.resource.common.entity.userInfo.UserConditionParam;
import com.tks.resource.common.entity.userInfo.UserSearchResult;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
public interface IUserService {
    PageInfo<UserSearchResult> getUserInfoByCondition(UserConditionParam userConditionParam);
    DeptAndRoleInfoResponse getDeptAndRoleInfo(String hosCode);
    UserAddOrUpdateParams saveOrUpdateUserInfo(UserAddOrUpdateParams userAddOrUpdateParams);
    int changUserStateById(String userId);
    int resetPassword(String userId);
}
