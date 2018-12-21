package com.cai.client.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 方式三 将RestTemplate最为一个Bean配置
 */
@Component
public class RestTemplateConfig {
    @Bean
    @LoadBalanced //重点体现在用了LoadBalanced这个注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
