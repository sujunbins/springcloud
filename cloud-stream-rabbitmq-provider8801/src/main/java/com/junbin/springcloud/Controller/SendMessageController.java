package com.junbin.springcloud.Controller;

import com.junbin.springcloud.Server.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 13:45 2022/6/15
 * @ Description：${description}
 **/
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }

}
