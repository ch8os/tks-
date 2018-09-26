package com.tks.third.web.booldsuger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.tks.third.common.SNResult;
import com.tks.third.web.booldsuger.entity.SNUserBloodsugerReq;
import com.tks.third.web.booldsuger.service.impl.BloodSugerServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sn")
public class BloodSugerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BloodSugerController.class);

	@Autowired
	BloodSugerServiceImpl bloodSugerService;
	
	@ApiOperation(value = "接收用户血糖数据", notes = "接收三诺推送的用户血糖数据")
    @RequestMapping(value = "/receiveBSData", method = RequestMethod.POST)
    SNResult receiveBSData(@RequestBody String jsonstr) throws Exception {
		LOGGER.info("receive bloodsuger data from sn [" + jsonstr + "]");
		SNUserBloodsugerReq req = JSON.parseObject(jsonstr, SNUserBloodsugerReq.class);
        return bloodSugerService.receiveBSData(req.getMsgdata());
    }
}
