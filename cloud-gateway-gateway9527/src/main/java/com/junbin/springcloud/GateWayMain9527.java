package com.junbin.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 10:16 2022/6/15
 * @ Description：${description}
 **/
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {

    public static void main(String[] args){
        SpringApplication.run(GateWayMain9527.class, args);
    }
}
