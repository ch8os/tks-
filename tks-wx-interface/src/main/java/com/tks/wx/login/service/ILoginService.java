package com.tks.wx.login.service;

import com.tks.wx.login.pojo.LoginUserResult;

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
}
