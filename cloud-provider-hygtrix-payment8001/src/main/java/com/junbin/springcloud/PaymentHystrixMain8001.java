package com.junbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 9:07 2022/6/16
 * @ Description：${description}
 **/
@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrixMain8001 {
    public static void main(String[] args){
        SpringApplication.run(PaymentHystrixMain8001.class, args);
    }
}
