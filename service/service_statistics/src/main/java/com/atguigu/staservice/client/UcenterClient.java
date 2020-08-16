package com.atguigu.staservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author
 * @date 2020/7/23-20:17
 */
@FeignClient(name = "service-ucenter")
@Component
public interface UcenterClient {
    @GetMapping("/educenter/member/countRegister/{day}")
    Integer countRegister(@PathVariable("day") String day);
}
