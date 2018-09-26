package com.tks.wx.access.service.impl;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tks.wx.access.service.IAccessService;
import com.tks.wx.common.message.resp.TextRespMessage;
import com.tks.wx.common.utils.MessageUtil;
import com.tks.wx.common.utils.WxUtils;

@Service
public class AccessServiceImpl implements IAccessService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccessServiceImpl.class);

	@Override
	public String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			LOGGER.info("----------get msg form wx, requestMap is [" + requestMap.toString() + "]");

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			TextRespMessage textMessage = new TextRespMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(WxUtils.RECRIVE_TEXT);
			textMessage.setFuncFlag(0);
			// 文本消息
			if (msgType.equals(WxUtils.RECRIVE_TEXT)) {
				// 接收用户发送的文本消息内容
				String content = requestMap.get("Content");

				if ("1".equals(content)) {
					textMessage.setContent("消息还在维护中");
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtil.textMessageToXml(textMessage);
				} else if ("2".equals(content)) {
					textMessage.setContent("请先绑定血糖仪");
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}else if ("3".equals(content)) {
					textMessage.setContent("绑定血糖仪后，让医生扫你的二维码");
					// 将文本消息对象转换成xml字符串
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
				else {
					textMessage.setContent("未知关键字");
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			} else if (msgType.equals(WxUtils.RECRIVE_EVENT)) {
				// 接收用户发送的文本消息内容
				String event = requestMap.get("Event");
				if(WxUtils.EVENT_SUBSCRIBE.equals(event)) {
					textMessage.setContent("欢迎你关注糖可视公众号，回复以下关键字，有惊喜哦 ！\n1 看最新消息 2 看血糖  3 找医生");
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			}

		} catch (Exception e) {
			LOGGER.error("-------wx message error",e);
		}
		return respMessage;
	}

}
