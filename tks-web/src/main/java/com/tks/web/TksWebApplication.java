package com.tks.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = "com.tks")
public class TksWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(TksWebApplication.class, args);
        System.out.println("-----------------启动成功-----------------");
    }
}
