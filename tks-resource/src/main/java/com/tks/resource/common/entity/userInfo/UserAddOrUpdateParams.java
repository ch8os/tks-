package com.tks.resource.common.entity.userInfo;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/27
 * @Description:
 */
@Data
public class UserAddOrUpdateParams{
    private String id;

    private String hosCode;

    private String username;

    private String password;

    private String userCode;

    private String sex;

    private String phone;

    private String state;

    private String createUser;

    private String modifyUser;

    private String name;

    private String roleId;

    private String deptCode;

    private String entryTime;
}
