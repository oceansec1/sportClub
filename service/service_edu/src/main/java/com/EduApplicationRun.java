package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sport"})
@EnableDiscoveryClient //nacos注册
public class EduApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(EduApplicationRun.class,args);
    }
}
