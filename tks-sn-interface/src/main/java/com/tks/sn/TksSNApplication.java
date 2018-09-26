package com.tks.sn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@MapperScan("com.tks.sn")
public class TksSNApplication {

    public static void main(String[] args) {
        SpringApplication.run(TksSNApplication.class, args);
    }
}
