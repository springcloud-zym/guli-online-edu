package com.atguigu.eduorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * @date 2020/7/23-15:02
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.atguigu")
@MapperScan("com.atguigu.eduorder.mapper")
public class OrderApplication8007 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8007.class,args);
    }
}
