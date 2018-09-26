package com.tks.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TksResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TksResourceApplication.class, args);
        System.out.println("-----------------启动成功-----------------");
    }
}
