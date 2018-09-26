package com.tks.wx.common.message.req;

import lombok.Data;

@Data
public class ImageReqMessage extends BaseReqMessage {
	/**
	 * 回复的消息内容
	 */
	private String picUrl;

}