package com.tks.wx.common.entity;

import java.util.List;

import lombok.Data;

/**
 * 获取关注者列表
 * @author gl
 *
 */
@Data
public class WeixinUserList {
	// 公众账号的总关注用户数
	private int total;
	// 获取的openID个数
	private int count;
	// OpenID列表
	private List<String> openIdList;
	// 拉取列表的后一个用户的OpenID
	private String nextOpenId;
}
