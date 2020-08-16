package com.atguigu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @date 2020/7/24-10:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication8222 {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication8222.class,args);
    }
}
