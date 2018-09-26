package com.tks.wx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = "com.tks")
public class TksWxApplication extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(TksWxApplication.class, args);
    }

    public  void  addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/template/**").addResourceLocations("classpath:/template/");
        super.addResourceHandlers(registry);
    }
}
