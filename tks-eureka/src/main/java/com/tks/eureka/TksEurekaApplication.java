package com.tks.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TksEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TksEurekaApplication.class, args);
        System.out.println("-----------------启动成功-----------------");
    }
}
