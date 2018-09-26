package com.tks.db.web.dept.service;

import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BDeptInfo;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
public interface IDeptService {
    PageInfo<BDeptInfo> getDeptInfoByCondition(BDeptInfo tDeptInfo, int pageSize, int pageNum);

    BDeptInfo saveOrUpdateDeptInfo(BDeptInfo tDeptInfo);

    int changDeptStateById(BDeptInfo tDeptInfo);
}
