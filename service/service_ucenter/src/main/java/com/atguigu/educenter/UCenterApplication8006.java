package com.atguigu.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * @date 2020/7/22-16:51
 */
@EnableDiscoveryClient
@ComponentScan("com.atguigu")
@SpringBootApplication
@MapperScan("com.atguigu.educenter.mapper")
public class UCenterApplication8006 {
    public static void main(String[] args) {
        SpringApplication.run(UCenterApplication8006.class,args);
    }
}
