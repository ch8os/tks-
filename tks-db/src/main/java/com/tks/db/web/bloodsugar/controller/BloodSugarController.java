package com.tks.db.web.bloodsugar.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tks.db.web.bloodsugar.service.impl.BloodSugarServiceImpl;
import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.resource.common.entity.BloodSugar.BSugarParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @ Purpose:
 * @Package Name: com.tks.web.menu.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@RestController
@RequestMapping("/BloodSugar")
@Api(description = "查询用户血糖数据信息")
public class BloodSugarController {
    @Autowired
    BloodSugarServiceImpl bloodSugarService;

    @ApiOperation(value = "获取所有用户血糖信息", notes = "查询血糖列表信息")
    @RequestMapping(value = "/getBSugarListByCondition", method = RequestMethod.POST)
    public PageInfo<SnUserBloodsuger> getOrganInfoByCondition(@RequestBody BSugarParam bSugarParam) throws ParseException {
        return bloodSugarService.getBSugarList(bSugarParam);
    }
/*
    @ApiOperation(value = "保存用户血糖信息", notes = "用于保存或者更新血糖信息")
    @RequestMapping(value = "/saveOrUpdateBloodSugarInfo", method = RequestMethod.POST)
    public BSugarInfo saveOrUpdateBloodSugarInfo(@RequestBody BSugarInfo bSugarInfo) {
        return bloodSugarService.saveOrUpdateTnmInfo(bSugarInfo);
    }

    @ApiOperation(value = "删除用户血糖信息", notes = "用于删除血糖信息")
    @RequestMapping(value = "/delBloodSugarInfo", method = RequestMethod.POST)
    public int delBloodSugarInfo(@RequestBody BSugarInfo bSugarInfo) {
        return bloodSugarService.delBloodSugarInfo(bSugarInfo);
    }*/
}
