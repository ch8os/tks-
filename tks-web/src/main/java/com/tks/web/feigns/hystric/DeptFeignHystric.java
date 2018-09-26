package com.tks.web.feigns.hystric;

import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;
import com.tks.web.feigns.IDeptFeignClient;
import com.github.pagehelper.PageInfo;

public class DeptFeignHystric implements IDeptFeignClient {
    @Override
    public PageInfo<BDeptInfo> getDeptInfoByCondition(DeptParam deptParam) {
        return null;
    }

    @Override
    public BDeptInfo saveOrUpdateDeptInfo(BDeptInfo tDeptInfo) {
        return null;
    }

    @Override
    public int changDeptStateById(BDeptInfo tDeptInfo) {
        return 0;
    }
}
