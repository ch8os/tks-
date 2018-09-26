package com.tks.wx.common.message.resp;

import lombok.Data;

@Data
public class TextRespMessage extends BaseRespMessage {
	/**
	 * 回复的消息内容
	 */
	private String Content;

}