package com.junbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 23:45 2022/6/15
 * @ Description：${description}
 **/
@SpringBootApplication
@EnableEurekaClient
public class MainApp8401 {
    public static void main(String[] args){
        SpringApplication.run(MainApp8401.class, args);
    }
}
