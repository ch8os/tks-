package com.tks.resource.common.entity;

import java.util.List;

import lombok.Data;

/**
 * @ Purpose: 用户登录实体类
 * @Package Name: com.dpm.resource.common.enity
 * @Author: liuxiaoxin
 * @Date: 2018/5/14
 */
@Data
public class LoginUserInfo {
    private boolean isAutoLogin = false;
    private String token;
    private BUserInfo userInfo;
    private List<BDeptInfo> userDeptList;
    private List<BRoleInfo> roleInfoList;
}
