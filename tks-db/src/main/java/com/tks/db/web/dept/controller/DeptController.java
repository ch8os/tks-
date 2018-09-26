package com.tks.db.web.dept.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tks.db.web.dept.service.impl.DeptServiceImpl;
import com.tks.resource.common.entity.BDeptInfo;
import com.tks.resource.common.entity.dept.DeptParam;

import io.swagger.annotations.ApiOperation;

/**
 * @Auther: mapengfei
 * @Date: 2018/5/30
 * @Description:
 */
@RestController
@RequestMapping(value ="/dept")
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @ApiOperation(value = "依据条件获取科室列表信息", notes = "查询科室列表信息")
    @RequestMapping(value = "/getDeptInfoByCondition", method = RequestMethod.POST)
    public PageInfo<BDeptInfo> getDeptInfoByCondition(@RequestBody DeptParam deptParam){
        return deptService.getDeptInfoByCondition(deptParam.getDeptInfo(),deptParam.getPageSize(),deptParam.getPageSize());
    }

    @ApiOperation(value = "保存科室信息", notes = "用于保存或者更新科室信息")
    @RequestMapping(value = "/saveOrUpdateDeptInfo", method = RequestMethod.POST)
    public BDeptInfo saveOrUpdateDeptInfo(@RequestBody BDeptInfo tDeptInfo) {
        return deptService.saveOrUpdateDeptInfo(tDeptInfo);
    }

    @ApiOperation(value = "更改科室状态", notes = "用于启用或停用科室信息")
    @RequestMapping(value = "/changDeptStateById", method = RequestMethod.POST)
    public int changDeptStateById(@RequestBody BDeptInfo tDeptInfo) {
        return deptService.changDeptStateById(tDeptInfo);
    }

}
