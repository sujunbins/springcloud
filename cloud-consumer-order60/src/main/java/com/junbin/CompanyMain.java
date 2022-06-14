package com.junbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 17:27 2022/6/14
 * @ Description：
 **/
@SpringBootApplication
@EnableEurekaClient
public class CompanyMain {
    public static void main(String[] args){
        SpringApplication.run(CompanyMain.class,args);

    }
}
