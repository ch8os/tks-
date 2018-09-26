package com.tks.pat;

import com.tks.pat.common.utils.SpringContextUtil;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCaching
@ComponentScan(basePackages = "com.tks")
public class TksPatApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws BeansException {
      //  ApplicationContext app = SpringApplication.run(TksPatApplication.class, args);
        //SpringContextUtil.setApplicationContext(app);


        SpringApplication.run(TksPatApplication.class, args);
       // System.out.println("-----------------启动成功-----------------");
    }

    public  void  addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/template/**").addResourceLocations("classpath:/template/");
        super.addResourceHandlers(registry);
    }




}
