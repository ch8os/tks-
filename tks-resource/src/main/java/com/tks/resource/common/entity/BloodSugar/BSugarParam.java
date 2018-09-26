package com.tks.resource.common.entity.BloodSugar;

import com.tks.resource.common.entity.SnUserBloodsuger;
import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common.enity.resource
 * @Author: liuxiaoxin
 * @Date: 2018/5/23
 */
@Data
public class BSugarParam {
    private SnUserBloodsuger organInfo;
    private int pageSize;
    private int pageNum;
}
