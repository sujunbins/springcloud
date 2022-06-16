package com.junbin.springcloud.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 23:46 2022/6/15
 * @ Description：${description}
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        log.info(Thread.currentThread().getName()+"\t"+"...testB");
        return "------testB";
    }

}
