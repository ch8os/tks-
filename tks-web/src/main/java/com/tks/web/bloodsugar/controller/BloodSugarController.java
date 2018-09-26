package com.tks.web.bloodsugar.controller;


import com.tks.resource.common.entity.BloodSugar.BSugarParam;
import com.tks.resource.freamwork.BusinessResult;
import com.tks.web.bloodsugar.service.impl.BloodSugarServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ Purpose:
 * @Package Name: com.tks.web.menu.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@RestController
@RequestMapping("/BloodSugar")
@Api(description = "用户血糖数据业务处理")
public class BloodSugarController {
    @Autowired
    BloodSugarServiceImpl bloodSugarService;

    @ApiOperation(value = "获取所有用户血糖数据", notes = "按条件获取用户血糖信息")
    @RequestMapping(value = "/getBSugarListByCondition", method = RequestMethod.POST)
    BusinessResult getBSugarList(@RequestBody BSugarParam bSugarParam) {
        return BusinessResult.success(bloodSugarService.getBSugarList(bSugarParam));
    }

   /* @ApiOperation(value = "保存用户血糖信息", notes = "用于保存或者更新血糖信息")
    @RequestMapping(value = "/saveOrUpdateBloodSugarInfo", method = RequestMethod.POST)
    public BusinessResult saveOrUpdateBloodSugarInfo(@RequestBody BSugarInfo bSugarInfo) {
        return BusinessResult.success(bloodSugarService.saveOrUpdateTnmInfo(bSugarInfo));
    }

    @ApiOperation(value = "删除用户血糖信息", notes = "用于删除血糖信息")
    @RequestMapping(value = "/delBloodSugarInfo", method = RequestMethod.POST)
    public BusinessResult delBloodSugarInfo(@RequestBody BSugarInfo bSugarInfo) {
        return BusinessResult.success(bloodSugarService.delBloodSugarInfo(bSugarInfo));
    }*/

}
