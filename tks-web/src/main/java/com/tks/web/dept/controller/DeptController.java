package com.tks.web.dept.controller;

import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;
import com.tks.resource.freamwork.BusinessResult;
import com.tks.web.dept.service.impl.DeptServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@RestController
@RequestMapping(value = "dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;
    @ApiOperation(value = "依据条件获取科室列表信息", notes = "查询科室列表信息")
    @RequestMapping(value = "/getDeptInfoByCondition", method = RequestMethod.POST)
    public BusinessResult getDeptInfoByCondition(@RequestBody DeptParam deptParam){
        return BusinessResult.success(deptService.getDeptInfoByCondition(deptParam));
    }

    @ApiOperation(value = "保存科室信息", notes = "用于保存或者更新科室信息")
    @RequestMapping(value = "/saveOrUpdateDeptInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateDeptInfo(@RequestBody BDeptInfo tDeptInfo) {
        return BusinessResult.success(deptService.saveOrUpdateDeptInfo(tDeptInfo));
    }

    @ApiOperation(value = "更改用户状态", notes = "用于启用或停用科室信息")
    @RequestMapping(value = "/changDeptStateById", method = RequestMethod.POST)
    public BusinessResult changDeptStateById(@RequestBody BDeptInfo tDeptInfo) {
        BusinessResult success = BusinessResult.success(deptService.changDeptStateById(tDeptInfo));

        return BusinessResult.success(deptService.changDeptStateById(tDeptInfo));
    }
}
