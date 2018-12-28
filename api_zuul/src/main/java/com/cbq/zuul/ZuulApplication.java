package com.cbq.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关，请求的入口，高可靠性，扩展性。
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
    /**
     * zuul有前置过滤器 和后置过滤器
     * 前置：限流，鉴权，参数校验，跨域
     * 后置：统计
     */
}

