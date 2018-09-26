package com.tks.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class TksConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(TksConfigApplication.class, args);
        System.out.println("-----------------启动成功-----------------");
    }
}
