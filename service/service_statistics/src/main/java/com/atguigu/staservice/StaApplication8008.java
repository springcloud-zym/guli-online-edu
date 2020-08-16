package com.atguigu.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author
 * @date 2020/7/23-20:07
 */
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.atguigu")
@MapperScan("com.atguigu.staservice.mapper")
public class StaApplication8008 {
    public static void main(String[] args) {
        SpringApplication.run(StaApplication8008.class,args);
    }
}
