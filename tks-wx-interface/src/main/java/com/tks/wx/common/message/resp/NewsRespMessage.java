package com.tks.wx.common.message.resp;

import java.util.List;

import lombok.Data;

@Data
public class NewsRespMessage extends BaseRespMessage {
	/**
	 * 图文消息个数，限制为10条以内
	 */
	private int ArticleCount;
	/**
	 * 多条图文消息信息，默认第一个item为大图
	 */
	private List<Article> Articles;

}