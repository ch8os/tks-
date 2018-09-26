package com.tks.wx.common.entity;

import lombok.Data;

/**
 * 临时二维码信息
 * @author gl
 *
 */
@Data
public class WeixinQRCode {
	// 获取的二维码ticket
	private String ticket;
	// 二维码有效时间，以秒为单位， 最大不超过1800秒
	private int expire_seconds;
}
