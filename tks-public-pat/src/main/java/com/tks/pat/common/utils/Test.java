package com.tks.pat.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class Test {
    @Autowired
    WebApplicationContext webApplicationConnect;

    @Autowired
    SpringContextUtil springContextUtil;

    public  static  String getToken(){
       // ApplicationContext applicationContext = SpringContextUtil.applicationContext;
        EhCacheCacheManager cacheCacheManager=(EhCacheCacheManager)SpringContextUtil.getBean("ehCacheCacheManager");
        //获取CacheManager类
        CacheManager cacheManager=cacheCacheManager.getCacheManager();
        Cache tokenCache = cacheManager.getCache("tokenCache");
        //Cache tokenCache = cacheManager.getCache("tokenCache");
        Element element=new Element("key",99999999);
        tokenCache.put(element);
        return  tokenCache.get("key").getObjectValue().toString();
    }

    public static void main(String[] args) {
       // System.err.println(getToken());
        //springContextUtil.getBean("")
        //AccessToken test = (AccessToken) SpringContextUtil.

        System.out.println(getToken());
    }
}
