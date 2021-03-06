package com.atguigu.eduorder.client;

import com.atguigu.commonutils.ordervo.CourseWebVoOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author
 * @date 2020/7/23-15:23
 */
@Component
@FeignClient(name = "service-edu")
public interface EduClient {
    @PostMapping("/eduservice/course/getCourseInfoOrder/{id}")
    CourseWebVoOrder getCourseInfoOrder(@PathVariable("id") String id);
}
