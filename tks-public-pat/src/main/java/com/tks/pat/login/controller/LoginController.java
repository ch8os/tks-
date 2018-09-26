package com.tks.pat.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tks.pat.login.pojo.LoginReq;
import com.tks.pat.login.service.impl.LoginServiceImpl;
import com.tks.resource.common.entity.TPatientInfo;
import com.tks.resource.freamwork.BusinessResult;

import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.login.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@RestController
@RequestMapping("/web")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;

    @ApiOperation(value = "用户登录", notes = "用户跳转登录首页")
    @RequestMapping(value = "/index")
    String toIntex() {
        return "/template/login";
    }


    @ApiOperation(value = "用户登录", notes = "用户依据用户名密码登录")
    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    BusinessResult doLogin(@RequestBody LoginReq loginReq) throws Exception {
        return BusinessResult.success(loginService.doLogin(loginReq));
    }

    @ApiOperation(value = "完善患者信息", notes = "完善患者信息")
    @RequestMapping(value = "/updatePatInfo", method = RequestMethod.POST)
    BusinessResult updatePatInfo(@RequestBody TPatientInfo tPatientInfo) throws Exception {
        return BusinessResult.success(loginService.updatePatInfo(tPatientInfo));
    }
    
    @ApiOperation(value = "发送验证码", notes = "发送验证码")
    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.GET)
    BusinessResult sendVerifyCode(@RequestParam(value = "mobile") String mobile){
        return BusinessResult.success(loginService.sendVerifyCode(mobile));
    }
}
