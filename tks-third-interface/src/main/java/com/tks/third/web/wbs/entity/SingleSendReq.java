package com.tks.third.web.wbs.entity;

import lombok.Data;

@Data
public class SingleSendReq {
	// 用户账号：长度最大6个字符，统一大写，如提交参数中包含apikey，则可以不用填写该参数及pwd，两种鉴权方式中只能选择一种方式来进行鉴权
	private String userid;
	// 用户密码：定长小写32位字符，如提交参数中包含apikey，则可以不用填写该参数及userid，两种鉴权方式中只能选择一种方式来进行鉴权
	private String pwd;
	// 短信接收的手机号：只能填一个手机号
	private String mobile;
	// 短信内容：最大支持1000个字(含签名)，发送时请预留至少10个字符的签名长度，一个字母或一个汉字都视为一个字符编码方式：urlencode（GBK明文）
	private String content;
	// 时间戳：24小时制格式：MMDDHHMMSS,即月日时分秒，定长10位,月、日、时、分、秒每段不足2位时左补0，密码选择MD5加密方式时必填该参数，密码选择明文方式时则不用填写
	private String timestamp;
	// 业务类型：最大可支持10个长度的英文字母、数字组合的字符串
	private String svrtype;
	// 扩展号：长度不能超过6位，注意通道号+扩展号的总长度不能超过20位，若超出则exno无效，如不需要扩展号则不用提交此字段或填空
	private String exno;
	// 用户自定义流水号：该条短信在您业务系统内的ID，比如订单号或者短信发送记录的流水号。填写后发送状态返回值内将包含用户自定义流水号。最大可支持64位的ASCII字符串：字母、数字、下划线、减号，如不需要则不用提交此字段或填空
	private String custid;
	// 自定义扩展数据：额外提供的最大64个长度的ASCII字符串：字母、数字、下划线、减号，作为自定义扩展数据，填写后，状态报告返回时将会包含这部分数据,如不需要则不用提交此字段或填空
	private String exdata;
}
