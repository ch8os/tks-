package com.tks.web.dept.service;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
public interface DeptService {

    PageInfo<BDeptInfo> getDeptInfoByCondition(DeptParam deptParam);

    BDeptInfo saveOrUpdateDeptInfo(BDeptInfo tDeptInfo);

    int changDeptStateById(BDeptInfo tDeptInfo);

}
