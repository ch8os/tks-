package com.tks.wx.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.tks.resource.common.utils.HttpUtils;
import com.tks.wx.common.entity.Template;
import com.tks.wx.common.entity.WeixinQRCode;

import net.sf.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Properties;

public class WxAPiUtils extends WxUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(WxAPiUtils.class);

	/**
	 * 获取access_token
	 * 
	 * @param
	 * @param
	 * @return AccessToken 返回接口凭证
	 */
	@Cacheable(cacheNames = {"accesstoken"})
	public synchronized static String getAccessToken() {
		//保存access_token文件名字
		String FileName = "WxTokenUtil.properties";
		try {
			// 从文件中获取token值及时间
			Properties prop = new Properties();// 属性集合对象
			//获取文件流
			InputStream fis = WxAPiUtils.class.getClassLoader().getResourceAsStream(FileName);
			prop.load(fis);// 将属性文件流装载到Properties对象中
			fis.close();// 关闭流
			//获取Appid，APPsecret
			String APPID = prop.getProperty("APPID");
			String APPSECRET = prop.getProperty("APPSECRET");
			// 获取accesstoken，初始值为空，第一次调用之后会把值写入文件
			String access_token = prop.getProperty("access_token");
			String expires_in = prop.getProperty("expires_in");
			String last_time = prop.getProperty("last_time");

			int int_expires_in = 0;
			long long_last_time = 0;

			try {
				int_expires_in = Integer.parseInt(expires_in);
				long_last_time = Long.parseLong(last_time);

			} catch (Exception e) {

			}
			//得到当前时间
			long current_time = System.currentTimeMillis();

			// 每次调用，判断expires_in是否过期，如果token时间超时，重新获取，expires_in有效期为7200
			if ((current_time - long_last_time) / 1000 >= int_expires_in) {
				//获取token url
				String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ APPID + "&secret=" + APPSECRET;
				//发送http请求得到json流
				com.alibaba.fastjson.JSONObject jobject = httpRequest(url);
				//从json流中获取access_token
				String  j_access_token = (String) jobject.get("access_token");
				Object expires_in1 = jobject.get("expires_in");
				// System.out.println(j_expires_in);
				//保存access_token
				if (j_access_token != null &&!j_access_token.equals("")) {
					prop.setProperty("access_token", j_access_token);
					prop.setProperty("expires_in", expires_in1.toString());
					prop.setProperty("last_time", System.currentTimeMillis() + "");

					URL url_ = WxAPiUtils.class.getClassLoader().getResource(FileName);
					FileOutputStream fos = new FileOutputStream(new File(url_.toURI()));
					prop.store(fos, null);
					fos.close();// 关闭流
				}
				//如果已经过期返回获取到的access_token
				return j_access_token;
			} else {
				//如果没有过期，返回从文件中读取的access_token
				return access_token;
			}
		} catch (Exception e) {
			return null;
		}


	}


	/**
	 * 创建临时带参数二维码
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param expireSeconds
	 *            二维码的有效时间，以秒为单位，最大不超过1800秒
	 * @param sceneId
	 *            场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return WeixinQRCode
	 */
	public static WeixinQRCode createTemporaryQRCode(String accessToken, int expireSeconds, int sceneId) {
		WeixinQRCode weixinQRCode = null;
		String requestUrl = TEMPORARY_QRCODE_URL.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonMsg = "{\"expire_seconds\": %d,\"action_name\": \"QR_SCENE\","
				+ "\"action_info\": {\"scene\": {\"scene_id\": %d}}}";
		// 创建临时带参数二维码
		String retStr = HttpUtils.sendGet(requestUrl, String.format(jsonMsg, expireSeconds, sceneId));
		if (StringUtil.isNotEmpty(retStr)) {
			weixinQRCode = JSON.parseObject(retStr, WeixinQRCode.class);
		}
		return weixinQRCode;
	}

	/**
	 * 创建永久带参数二维码
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param sceneId
	 *            场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
	 * @return String
	 */
	public static String createPermanentQRCode(String accessToken, int sceneId) {
		String ticket = null;
		String requestUrl = PERMANENT_QRCODE_URL.replace("ACCESS_TOKEN", accessToken);
		// 需要提交的json数据
		String jsonMsg = "{\"action_name\": \"QR_SCENE\",\"action_info\": {\"scene\": {\"scene_id\": %d}}}";
		// 创建临时带参数二维码
		String retStr = HttpUtils.sendJsonPost(requestUrl, String.format(jsonMsg, sceneId));
		if (StringUtil.isNotEmpty(retStr)) {
		}
		return ticket;
	}
	
	/**
     * 发送模板消息方法
     * @param token
     * @param template
     * @return
     */
    public static boolean sendTemplateMsg( String token, Template template) {
        boolean flag = false;
        String requestUrl = SEND_TEMPLATE_URL.replace("ACCESS_TOKEN", token);

        JSONObject jsonResult = CommonUtil.httpRequest(requestUrl, "POST", template.toJSON());
        if (jsonResult != null) {
            int errorCode = jsonResult.getInt("errcode");
            String errorMessage = jsonResult.getString("errmsg");
            if (errorCode == 0) {
            	LOGGER.info("------------模板消息发送成功:" + errorCode + "," + errorMessage);
                flag = true;
            } else {
            	LOGGER.info("------------模板消息发送失败:" + errorCode + "," + errorMessage);
                flag = false;
            }
        }
        return flag;


    }



	// 获取accesstoken
	public synchronized static com.alibaba.fastjson.JSONObject httpRequest(String requestUrl) {
		com.alibaba.fastjson.JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
					.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod("GET");

			httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = com.alibaba.fastjson.JSONObject.parseObject(buffer.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

}
