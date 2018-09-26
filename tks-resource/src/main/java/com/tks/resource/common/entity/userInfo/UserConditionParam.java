package com.tks.resource.common.entity.userInfo;

import lombok.Data;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/25
 * @Description:
 */
@Data
public class UserConditionParam {
    private int pageSize;
    private int pageNum;
    private UserParam userInfo;
}
