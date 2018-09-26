package com.tks.wx.common.utils;

import com.tks.wx.common.MyX509TrustManager;
import net.sf.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;

/**
 * 调用微信请求接口
 */
public class CommonUtil {

    /**
     *
     * @param requestUrl    请求的地址
     * @param requestMethod 请求的方式
     * @param outputStr 提交的数据
     * @return
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr){
        JSONObject jsonObject = null;
        try{
            //创建SSL对象
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();

            conn.setSSLSocketFactory(ssf);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);

            //当提交的数据不为null，向输入流写数据
            if(null!=outputStr){
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            //获取输入流
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //读取响应内容
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while((str=bufferedReader.readLine())!=null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());

        }catch(ConnectException e){
            System.err.println("连接超时");
        }catch(Exception e1){
            e1.printStackTrace();
            System.err.println("请求异常");
        }

        return jsonObject;
    }

}
