package com.tks.resource.common.entity.userInfo;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/26
 * @Description:
 */
@Data
public class DeptAndRoleInfoResponse {
    private List<Map<String,String>> deptInfo;
    private List<Map<String,String>> roleInfo;
}
