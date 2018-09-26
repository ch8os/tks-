package com.tks.third.web.wbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tks.third.web.wbs.service.impl.WbsServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wbs")
public class WbsController {
	@Autowired
	WbsServiceImpl wbsService;
	
	@ApiOperation(value = "向用户发送短信消息", notes = "向用户发送短信消息")
    @RequestMapping(value = "/singleSend", method = RequestMethod.GET)
    String singleSend(@RequestParam(value = "mobile") String mobile) throws Exception {
		return wbsService.singleSend(mobile);
    }
}
