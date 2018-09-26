package com.tks.wx.common.message.req;

import lombok.Data;

@Data
public class LocationReqMessage extends BaseReqMessage {
	/**
	 * 媒体ID
	 */
	private String MediaId;
	/**
	 * 语音格式
	 */
	private String Format;

}