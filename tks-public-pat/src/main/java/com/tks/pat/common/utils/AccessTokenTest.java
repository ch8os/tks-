package com.tks.pat.common.utils;

import com.alibaba.fastjson.JSONObject;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class AccessTokenTest {
    private final  Logger logger= LoggerFactory.getLogger(AccessTokenTest.class);

    public  synchronized  static AccessToken getAccessToken() {
        AccessToken accessToken=new AccessToken();
        //Cache cache = EhCacheUtil.gettokenCache();
        //创建缓存管理并且将数据存入缓存
        CacheManager cacheManager=CacheManager.create(AccessTokenTest.class.getClassLoader().getResourceAsStream("config/ehcache.xml"));
        Cache tokenCache1 = cacheManager.getCache("tokenCache");
        /*Element element = new Element("","");
        tokenCache1.put(element);*/
        Element result1 = tokenCache1.get("last_time");//就是取到的值
        tokenCache1.get("last_time");

        //EhCacheUtil.init();
      /*  Cache cache = EhCacheUtil.gettokenCache();
        AccessToken result = (AccessToken)EhCacheUtil.get(cache, "last_time");*/
        long current_time = System.currentTimeMillis();
        //JSONObject jsonObject = JSONObject.parseObject(result.toString());
        String last_time="";
        if(result1!=null) {
            last_time = result1.getObjectValue().toString();
        }
        if(last_time==""||(current_time -  Long.parseLong(last_time)) / 1000 < Integer.parseInt(7000+"")){
            //获取token url
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                    + "wx04ca72a785f13f9b" + "&secret=" + "128f0e90443e068eae95d52373d8d3e7";
            JSONObject jobject=null;
            try {
                //发送http请求得到json流
                jobject = httpRequest(url);
            }catch (Exception e){

            }
            //从json流中获取access_token
            String  j_access_token = (String) jobject.get("access_token");
            Object expires_in = jobject.get("expires_in");
            accessToken.setAccesstoken(j_access_token);
            accessToken.setExpiresin(Integer.parseInt(expires_in.toString()));
            accessToken.setLast_time(current_time+"");


            CacheManager tokenCache = CacheManager.getCacheManager("tokenCache");
            Cache last_time1 = tokenCache.getCache("last_time");
            Element last_time2 = new Element("last_time", accessToken);
            last_time1.put(last_time2);


            System.err.println(last_time1.get("lat_time"));

        }else {
            //直接返回缓存内容
        }




        return accessToken;
    }


    // 获取accesstoken
    public synchronized static JSONObject httpRequest(String requestUrl) {
        JSONObject jsonObject = null;
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
            jsonObject = JSONObject.parseObject(buffer.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
