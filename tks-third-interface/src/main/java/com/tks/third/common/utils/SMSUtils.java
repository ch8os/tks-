package com.tks.third.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.tks.resource.common.utils.CypherUtil;
import com.tks.resource.common.utils.DateUtil;
import com.tks.resource.common.utils.HttpUtils;
import com.tks.third.web.wbs.entity.SingleSendReq;

@Component("MobileMessageUtils")
@PropertySource(value = "classpath:config/config.properties")
public class SMSUtils {
	@Value("${wbs.userid}")
	private String userid;
	@Value("${wbs.pwd}")
	private String pwd;
	@Value("${wbs.ip}")
	private String ip;
	@Value("${wbs.ip1}")
	private String ip1;
	@Value("${wbs.ip2}")
	private String ip2;
	
	private String SINGLE_SEND_URL = "http://ip:port/sms/v2/std/single_send";
	
	private String SMS_CONTENT_VERIFYCODE = "同事您好，感谢您对此次测试的配合。验证码:_VERIFYCODE";
	
	/**
	 * 调用短信接口机发送短信
	 * @param singleSendReq
	 * @return
	 */
	public String singleSend(SingleSendReq singleSendReq){
		String reqUrl = SINGLE_SEND_URL.replace("ip:port", ip);
		singleSendReq.setUserid(userid);
		singleSendReq.setPwd(pwd);
		try {
			String content = SMS_CONTENT_VERIFYCODE.replace("_VERIFYCODE", singleSendReq.getContent());
			singleSendReq.setContent(URLEncoder.encode(content, "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		singleSendReq.setTimestamp(DateUtil.getCurrentDate(DateUtil.DATE_TIME_PATTERN2));
		StringBuilder sb = new StringBuilder();
		sb.append(singleSendReq.getUserid()).append("00000000").append(singleSendReq.getPwd()).append(singleSendReq.getTimestamp());
		singleSendReq.setPwd(CypherUtil.MD5(sb.toString()));
		return HttpUtils.sendJsonPost(reqUrl, JSON.toJSONString(singleSendReq));
	}
	
	/**
	 * 生成随机6位验证码
	 * @return
	 */
	public String genVerifyCode() {
		return String.valueOf(new Random().nextInt(899999) + 100000);
	}
}
