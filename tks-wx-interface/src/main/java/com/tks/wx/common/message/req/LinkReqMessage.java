package com.tks.wx.common.message.req;

import lombok.Data;

@Data
public class LinkReqMessage extends BaseReqMessage {
	/**
	 * 消息标题
	 */
	private String Title;
	/**
	 * 消息描述
	 */
	private String Description;
	/**
	 * 消息链接
	 */
	private String Url;

}