package com.junbin.springcloud.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 10:39 2022/6/15
 * @ Description：全局過濾器
 **/
@Slf4j
@Configuration
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        log.info("***********come in MyLogGateWayFilter:  "+new Date());

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
