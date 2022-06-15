package com.junbin.springcloud.Server.Impl;

import com.junbin.springcloud.Commom.Util.Snowflake;
import com.junbin.springcloud.Server.IMessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


import javax.annotation.Resource;


/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 13:46 2022/6/15
 * @ Description：定义消息的推送chanal
 **/
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Value("${server.port}")
    private String port;

    @Resource(name = "output") //bean名称必须为outpuit
    private MessageChannel channel;
    @Override
    public String send() {

        String serial = String.valueOf(Snowflake.getSnowflakeId());
        channel.send(MessageBuilder.withPayload(serial).build());
        System.out.println(port+":  *****serial: "+serial);
        return null;
    }
}
