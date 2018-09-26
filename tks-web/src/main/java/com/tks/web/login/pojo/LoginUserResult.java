package com.tks.web.login.pojo;

import java.util.List;

import com.tks.resource.common.entity.BDeptInfo;
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
    private List<BDeptInfo> userDepts;
    private List<UserMenu> userMenus;


}
