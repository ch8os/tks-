package com.tks.wx.common.entity;

import lombok.Data;

/**
 * 公众账号分组信息
 * 
 * @author gl
 *
 */
@Data
public class WeixinGroup {
	// 分组id
	private int id;
	// 分组名称
	private String name;
	// 分组内用户数
	private int count;
}
