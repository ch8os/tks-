package com.tks.doc.login.pojo;

import com.tks.resource.common.entity.BUserInfo;

import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.pojo
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@Data
public class LoginUserResult {
    private String token;
    private BUserInfo userInfo;
}
