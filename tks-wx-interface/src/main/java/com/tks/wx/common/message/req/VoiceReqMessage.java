package com.tks.wx.common.message.req;

import lombok.Data;

@Data
public class VoiceReqMessage extends BaseReqMessage {
	/**
	 * 地理位置维度
	 */
	private String Location_X;
	/**
	 * 地理位置经度
	 */
	private String Location_Y;

	/**
	 * 地图缩放大小
	 */
	private String Scale;

	/**
	 * 地理位置信息
	 */
	private String Label;
}