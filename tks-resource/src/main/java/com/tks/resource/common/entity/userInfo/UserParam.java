package com.tks.resource.common.entity.userInfo;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
@Data
public class UserParam {
    private String name;
    private String userCode;
    private String deptCode;
    private String sex;
    private String roleId;
    private String state;
    private String startDate;
    private String endDate;
}
