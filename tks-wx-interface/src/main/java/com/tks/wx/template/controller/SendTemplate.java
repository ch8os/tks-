package com.tks.wx.template.controller;


import com.tks.resource.common.entity.SnUserBloodsuger;
import com.tks.wx.template.service.impl.SendTemplateServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/wechat")
public class SendTemplate {

    @Autowired
    private SendTemplateServiceImpl sendTemplateService;

    @ApiOperation(value = "接收用户血糖数据", notes = "接收三诺推送的用户血糖数据")
    @RequestMapping(value = "/sendTemplateMsg", method = RequestMethod.POST)
    Boolean receiveBSData(@RequestBody SnUserBloodsuger subs, String openId) throws Exception {
        Boolean result = sendTemplateService.sendTemplateMsgs(subs, openId);
        return result;
    }
}
