package com.tks.third.common;

import lombok.Data;

@Data
public class WBSResult {
	// 0：成功 非0：失败 具体参考接口文档
	private int result;
	
	// 平台流水号：返回个性化群发第一条记录中的msgid，非0，64位整型， 对应Java和C#的long，不可用int解析。result非0时，msgid为0
	private long msgid;
	
	// 用户自定义流水号：默认与请求报文multimt包结构内第一条数据的custid保持一致，若请求报文中没有custid参数或值为空，则返回由梦网生成的代表本批短信的唯一编号result非0时，custid为空
	private String custid;
}
