package com.junbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 16:22 2022/6/14
 * @ Description：${description}
 **/
@SpringBootApplication
@EnableEurekaClient
public class payment8003 {
    public static void main(String[] args) {
        SpringApplication.run(payment8003.class, args);
    }
}
