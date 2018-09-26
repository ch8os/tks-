package com.tks.third;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@MapperScan("com.tks.third")
public class TksThirdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TksThirdApplication.class, args);
    }
}
