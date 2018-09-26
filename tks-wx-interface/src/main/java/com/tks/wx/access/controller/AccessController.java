package com.tks.wx.access.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tks.wx.access.service.IAccessService;
import com.tks.wx.common.utils.ShaUtils;
import com.tks.wx.common.utils.WxUtils;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wx/interface")
public class AccessController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessController.class);

	 @Autowired
	 IAccessService accessService;
	 
	@ApiOperation(value = "获取微信消息", notes = "get方式")
	@RequestMapping(value = "/getmsg", method = RequestMethod.GET)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		LOGGER.info("get msg form wx, para is [signature:" + signature + ",timestamp" + timestamp + ",nonce" + nonce
				+ ",echostr" + echostr);
		if (null != timestamp && null != nonce && null != echostr && null != signature) {
			if (valid(WxUtils.TOKEN, signature, timestamp, nonce)) {
				LOGGER.info("valid request success");
			}
		} else {
		}
		response.getWriter().write(echostr);
	}

	public static boolean valid(String token, String signature, String timestamp, String nonce) {
		List<String> ss = new ArrayList<String>();
		ss.add(timestamp);
		ss.add(nonce);
		ss.add(token);
		Collections.sort(ss);

		StringBuilder builder = new StringBuilder();
		for (String s : ss) {
			builder.append(s);
		}
		return signature.equalsIgnoreCase(ShaUtils.encode(builder.toString()));
	}

	@ApiOperation(value = "获取微信消息", notes = "post方式")
	@RequestMapping(value = "/getmsg", method = RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = accessService.processRequest(request);

		// 响应消息
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(respMessage);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
			out = null;
		}
	}
}
