package com.tks.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class TksSleuthApplication 
{
	public static void main(String[] args) {
        SpringApplication.run(TksSleuthApplication.class, args);
        System.out.println("-----------------启动成功-----------------");
    }
}
