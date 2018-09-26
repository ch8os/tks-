package com.tks.wx.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 获取accesstoken(公众号的全局唯一票据)  
 * @author gl
 *
 */
@Data
public class AccessToken implements Serializable {
	// 获取到的凭证
	private String accesstoken;
	// 凭证有效时间，单位：秒 有效期为7200秒
	private int expiresin;
	//记录上一次获取access_token的时间
	private  String last_time;
}
