package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sport"})
public class EduApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(EduApplicationRun.class,args);
    }
}
