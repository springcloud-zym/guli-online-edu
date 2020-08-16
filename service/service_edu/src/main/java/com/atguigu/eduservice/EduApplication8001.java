package com.atguigu.eduservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * @date 2020/7/14-17:01
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.atguigu.eduservice.mapper")
@ComponentScan(basePackages = {"com.atguigu"})
public class EduApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication8001.class,args);
    }
}
