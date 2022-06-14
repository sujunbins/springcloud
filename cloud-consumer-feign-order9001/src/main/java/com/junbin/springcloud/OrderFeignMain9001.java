package com.junbin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 21:53 2022/6/14
 * @ Description：接口+注解：微服务调用接口 + @FeignClient
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain9001 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain9001.class, args);

    }
}
