package com.atguigu.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * @date 2020/7/22-10:09
 */
@SpringBootApplication
@ComponentScan({"com.atguigu"})
@MapperScan("com.atguigu.educms.mapper")
public class CmsApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication8004.class,args);
    }
}
