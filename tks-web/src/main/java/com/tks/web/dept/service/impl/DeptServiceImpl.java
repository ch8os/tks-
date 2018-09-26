package com.tks.web.dept.service.impl;


import com.github.pagehelper.PageInfo;
import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;
import com.tks.resource.freamwork.BusinessException;
import com.tks.web.dept.service.DeptService;
import com.tks.web.feigns.IDeptFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private IDeptFeignClient deptFeignClient;

    @Override
    public PageInfo<BDeptInfo> getDeptInfoByCondition(DeptParam deptParam) {
        return deptFeignClient.getDeptInfoByCondition(deptParam);
    }
    @Override
    public BDeptInfo saveOrUpdateDeptInfo(BDeptInfo tDeptInfo) {
        if(ObjectUtils.isEmpty(tDeptInfo))
            throw new BusinessException("科室信息不可为空");
        return deptFeignClient.saveOrUpdateDeptInfo(tDeptInfo);
    }

    @Override
    public int changDeptStateById(BDeptInfo tDeptInfo) {
        return deptFeignClient.changDeptStateById(tDeptInfo);
    }
}
