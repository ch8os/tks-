package com.tks.wx.common.message.resp;

import lombok.Data;

/**
 * 音乐消息
 */
@Data
public class MusicRespMessage extends BaseRespMessage {
	/**
	 * 音乐
	 */
	private Music Music;
}