package com.tks.wx.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WxUtils {
	//令牌
	public static final String TOKEN = "FUMEIYU_WX_TOKEN";

	//公众号中配置获取openId的回调域名
	public static final String Domain = "https://www.baidu.com";

	//公众号中配置血糖消息模板ID
	public static final String TemplateId = "8HMI7FmAZJ79_5WoXs6QOVIBt4FkxnBSnvFJmy4Xlqs";

	//消息加解密密钥
	public static final String EncodingAESKey = "KdZ5GB70aeXMe2tMGth0FEU4gVSCVDcPsFElrPB3LZG";

	//开发者ID是公众号开发识别码，配合开发者密码可调用公众号的接口能力。
	public static final String AppID = "wx04ca72a785f13f9b";

	//开发者密码是校验公众号开发者身份的密码，切勿丢失，否则要去公众号平台重置 
	public static final String AppSecret = "128f0e90443e068eae95d52373d8d3e7";

	// 接收消息类型：文本 
	public final static String RECRIVE_TEXT = "text";
	// 接收消息类型：图片
	public final static String RECRIVE_IMAGE = "image";
	// 接收消息类型：语音
	public final static String RECRIVE_VOICE = "voice";
	// 接收消息类型：视频
	public final static String RECRIVE_VIDEO = "video";
	// 接收消息类型：地理位置
	public final static String RECRIVE_LOCATION = "location";
	// 接收消息类型：链接
	public final static String RECRIVE_LINK = "link";
	// 接收消息类型：推送
	public final static String RECRIVE_EVENT = "event";

	// 回复消息类型：文本
	public final static String REQUEST_TEXT = "text";
	// 回复消息类型：图片
	public final static String REQUEST_IMAGE = "image";
	// 回复消息类型：语音
	public final static String REQUEST_VOICE = "voice";
	// 回复消息类型：视频
	public final static String REQUEST_VIDEO = "video";
	// 回复消息类型：音乐
	public final static String REQUEST_MUSIC = "music";
	// 回复消息类型：图文
	public final static String REQUEST_NEWS = "news";

	// 事件类型：subscribe(订阅)
	public final static String EVENT_SUBSCRIBE = "subscribe";
	// 事件类型：unsubscribe(取消订阅)
	public final static String EVENT_UNSUBSCRIBE = "unsubscribe";
	// 事件类型：LOCATION(上报地理位置事件)
	public final static String EVENT_LOCATION = "LOCATION";
	// 事件类型：CLICK(自定义菜单点击事件)
	public final static String EVENT_CLICK = "CLICK";

	/**
	 * 扫描带参数二维码事件
	 * 用户扫描带场景值二维码时，可能推送以下两种事件：
	 1.如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
	 2.如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
	 */
	// 事件类型：subscribe(用户未关注时，进行关注后的事件推送)
	public final static String EVENT_QRCODE_SUBSCRIBE = "subscribe";
	// 事件类型：scan(用户已关注时的事件推送)
	public final static String EVENT_QRCODE_SCAN = "scan";


	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 开发者可通过OpenID来获取用户基本信息 url
	protected final static String GET_PERSONALINF_URL="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 通过OpenID获取查询用户所在分组url
	protected final static String GET_PERSONGROUPID_URL="https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=ACCESS_TOKEN";
	/**
	 *  OAuth2.0引导关注者打开 用户同意授权，获取code页面url
	 *  1.scope的设置为：snsapi_base（不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo （弹出授权页面)
	 *  2.redirect_uri：授权后重定向的回调链接地址，请使用urlencode对链接进行处理  方法再commonutil的urlEncodeUTF8()
	 */
	public final static String FANS_GET_CODE="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	// OAuth2.0通过code换取网页授权access_token
	protected final static String OAUTH2_ACCESSTOKEN_URL="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	// OAuth2.0刷新access_token
	protected final static String REFRESH_ACCESSTOKEN_URL="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	// OAuth2.0拉取用户信息(需scope为 snsapi_userinfo)
	protected final static String OAUTH2_USERINFO_URL="https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 主动发送客服消息url
	protected final static String SEND_CUSTOM_URL="https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	// 生成临时二维码url
	protected final static String TEMPORARY_QRCODE_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// 生成永久二维码url
	protected final static String PERMANENT_QRCODE_URL="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// 换取二维码url
	protected final static String GET_QRCODE_URL="https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	// 获取关注者列表url
	protected final static String GET_USERLIST_URL="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

	// 获取所有分组信息url
	protected final static String GET_GROUPS_URL="https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
	// 创建分组url
	protected final static String CREATE_GROUPS_URL="https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
	// 修改分组url
	protected final static String UPDATE_GROUPS_URL="https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
	// 移动用户分组url
	protected final static String REMOVE_MEMBER_URL="https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";

	// 上传多媒体文件url
	protected final static String UPLOAD_MEDIA_URL="http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
	// 下载多媒体文件url
	protected final static String DOWNLOAD_MEDIA_URL="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

	// 菜单创建（POST） 限100（次/天）
	protected final static String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 菜单查询（GET）
	protected final static String GET_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
	// 菜单删除（GET）
	protected final static String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

	// 发送模板消息
	protected final static String SEND_TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

	/**
	 * URL编码(utf-8)
	 *
	 * @param source
	 * @return String
	 */
	public static String urlEncodeUTF8(String source) {
		String result=source;
		try {
			result=URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 根据类型判断文件扩展名
	 *
	 * @param contentType 内容类型
	 * @return String
	 */
	public static String getFileExt(String contentType) {
		String fileExt="";
		if ("image/jpeg".equals(contentType)) {
			fileExt=".jpg";
		}else if ("audio/mpeg".equals(contentType)) {
			fileExt=".mp3";
		}else if ("audio/amr".equals(contentType)) {
			fileExt=".amr";
		}else if ("video/mp4".equals(contentType)) {
			fileExt=".mp4";
		}else if ("video/mpeg4".equals(contentType)) {
			fileExt=".mp4";
		}
		return fileExt;
	}
}
