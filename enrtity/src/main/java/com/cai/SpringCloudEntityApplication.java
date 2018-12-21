package com.cai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudEntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEntityApplication.class, args);
    }

}

