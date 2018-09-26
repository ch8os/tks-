package com.tks.third.web.wbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSON;
import com.tks.third.common.WBSResult;
import com.tks.third.common.utils.SMSUtils;
import com.tks.third.web.wbs.entity.SingleSendReq;
import com.tks.third.web.wbs.service.IWbsService;

@Service
public class WbsServiceImpl implements IWbsService {
	@Autowired
	SMSUtils smsUtils;

	/**
	 * 生成并发送短信验证码
	 */
	public String singleSend(String mobile) {
		SingleSendReq singleSendReq = new SingleSendReq();
		String verifyCode = smsUtils.genVerifyCode();
		singleSendReq.setContent(verifyCode);
		singleSendReq.setMobile(mobile);
		String rst = smsUtils.singleSend(singleSendReq);
		WBSResult result = JSON.parseObject(rst, WBSResult.class);
		if(ObjectUtils.isEmpty(result) || result.getResult() != 0) {
			verifyCode = "-1";
		}
		return verifyCode;
	}
}
