package com.tks.web.login.service;

import java.util.List;

import com.tks.web.login.pojo.LoginUserResult;
import com.tks.web.login.pojo.UserMenu;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
public interface ILoginService {
    String getRefreshToken(String userKey);

    LoginUserResult doLogin(String userCode, String password) throws Exception;

    void doLogout(String token);

    List<UserMenu> getUserMenuByRoleId(String roleId);
}
