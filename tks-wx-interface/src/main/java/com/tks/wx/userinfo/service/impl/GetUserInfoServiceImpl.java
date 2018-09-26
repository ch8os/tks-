package com.tks.wx.userinfo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tks.wx.common.entity.PersonalInf;
import com.tks.wx.common.utils.WxUtils;
import com.tks.wx.userinfo.service.IGetUserInfoService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;


@Service
public class GetUserInfoServiceImpl extends WxUtils implements IGetUserInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetUserInfoServiceImpl.class);

	//用户标识
	private  static String openId;
	//网页授权的access_token
	private  static  String  access_token;
	//用户昵称
	private  static  String nickname;
	//用户性别
	private  static  String sex;
	//用户所在国家
	private  static  String country;
	//用户资料填写省份
	private  static  String province;
	//用户资料填写的城市
	private  static  String city;
	//用户头像（最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空）
	private  static  String headimgurl;
	//	只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	private  static  String unionid;

	@Override
	public void redirect(HttpServletResponse response) {
		//引导关注者打开 用户同意授权，获取code页面url
		String url="";
		try {
			//对重定向url进行编码，官方文档要求 //公众号中配置的回调域名（网页授权回调域名）
			url = URLEncoder.encode("https://fumeiyuyl.com/tks-wx-interface/template/getOpenId.html", "utf-8");
			//网页授权的snsapi_userinfo授权
			String fansGetCode = FANS_GET_CODE.replace("APPID",AppID).replace("REDIRECT_URI",url).replace("SCOPE","snsapi_userinfo").replace("","");
			response.sendRedirect(fansGetCode);
		} catch (UnsupportedEncodingException e) {
			System.out.println("重定向url编码失败：>>" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("response重定向失败：>>" + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public PersonalInf getuserInfo(HttpServletRequest request, HttpServletResponse response) {
		//获取重定向携带的code参数值
		String code = request.getParameter("code");

        PersonalInf personalInf=null;
		if (openId==null||openId.equals("")) {
			/*
			 * 根据得到的code参数，内部请求获取openId的方法。
			 */
			personalInf = getOpenId(request, response, code);
        }
		LOGGER.info("成功得到用户信息>>>>>>>>"+personalInf);
		return personalInf;
	}

	//发送请求，根据code获取openId   同时获取用户的个人信息
	public PersonalInf getOpenId(HttpServletRequest request, HttpServletResponse response,String code) {

		//封装获取openId的微信
		String oauth2_accesstoken_url = OAUTH2_ACCESSTOKEN_URL.replace("APPID", AppID).replace("SECRET", AppSecret).replace("CODE", code);

		HttpGet get=new HttpGet(oauth2_accesstoken_url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpResponse execute = httpClient.execute(get);
			HttpEntity entity = execute.getEntity();
			String jsonStr = EntityUtils.toString(entity);
			Map<String,String> json = (Map) JSONObject.parse(jsonStr);
			openId= json.get("userinfo");
			access_token=json.get("access_token");
			System.out.println("获取的openID：" + openId);
		} catch (JsonParseException e) {
			LOGGER.error("json解析失败：", e);
		} catch (JsonMappingException e) {
			LOGGER.error("map转换成json失败：", e);
		} catch (Exception e) {
			LOGGER.error("http获取openId请求失败：", e);
		}
		//拉取用户信息

		String oauth2_usertnfo_url = OAUTH2_USERINFO_URL.replace("ACCESS_TOKEN", access_token).replace("OPENID", openId);
		HttpGet get2=new HttpGet(oauth2_usertnfo_url);
		CloseableHttpClient httpClient2 = HttpClients.createDefault();
		try {
			HttpResponse execute = httpClient2.execute(get2);
			HttpEntity entity = execute.getEntity();
			String jsonStr = EntityUtils.toString(entity);
			Map<String,String> json = (Map) JSONObject.parse(jsonStr);
			nickname=json.get("nickname");
			sex=json.get("sex");
			city=json.get("city");
			headimgurl=json.get("headimgurl");
			unionid=json.get("unionid");
			country=json.get("country");
			province=json.get("province");
		} catch (JsonParseException e) {
			LOGGER.error("json解析失败：", e);
		} catch (JsonMappingException e) {
			LOGGER.error("map转换成json失败：", e);
		} catch (Exception e) {
			LOGGER.error("http获取openId请求失败：", e);
		}
		PersonalInf personalInf=new PersonalInf();
		personalInf.setOpenid(openId);
		personalInf.setNickname(nickname);
		personalInf.setSex(Integer.parseInt(sex));
		personalInf.setCountry(country);
		personalInf.setProvince(province);
		personalInf.setCity(city);
		personalInf.setHeadimgurl(headimgurl);
		//return openId;
		/*  * 将openId保存到session中，当其他业务获取openId时，
		 * 可先从session中获取openId.*/
		request.getSession().setAttribute("openId", openId);
		return  personalInf;
	}

}
