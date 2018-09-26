package com.tks.doc.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tks.doc.login.pojo.LoginReq;
import com.tks.doc.login.service.impl.LoginServiceImpl;
import com.tks.resource.common.entity.TDoctorInfo;
import com.tks.resource.freamwork.BusinessResult;

import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@RestController
@RequestMapping("/public/doc")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @ApiOperation(value = "用户登录", notes = "用户依据用户名密码登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    BusinessResult doLogin(@RequestBody LoginReq loginReq) throws Exception {
        return BusinessResult.success(loginService.doLogin(loginReq));
    }

    @ApiOperation(value = "完善医生信息", notes = "完善医生信息")
    @RequestMapping(value = "/updateDocInfo", method = RequestMethod.POST)
    BusinessResult updateDocInfo(@RequestBody TDoctorInfo tDoctorInfo) throws Exception {
        return BusinessResult.success(loginService.updateDocInfo(tDoctorInfo));
    }
}
