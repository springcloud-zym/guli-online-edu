package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.commonutils.ordervo.CourseWebVoOrder;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseWebVo;
import com.atguigu.eduservice.entity.vo.CourseInfoVO;
import com.atguigu.eduservice.entity.vo.CoursePublishVO;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-17
 */
//@CrossOrigin
@RestController
@RequestMapping("/eduservice/course")
public class EduCourseController {
    @Autowired
    EduCourseService courseService;

    //课程列表
    @GetMapping("/getCourseList")
    public R getCourseList(){
        List<EduCourse> list = courseService.list(null);
        return R.ok().data("list",list);
    }

    //添加课程基本信息
    @PostMapping("/addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVO courseInfoVO){
        //返回添加之后的课程id
        String id = courseService.saveCourseInfo(courseInfoVO);

        return R.ok().data("courseId",id);
    }

    //根据课程id查询课程的基本信息
    @GetMapping("/getCourseInfo/{courseId}")
    public R getCourseInfo(@PathVariable("courseId")String courseId){
        CourseInfoVO courseInfoVO = courseService.getCourseInfo(courseId);

        return R.ok().data("courseInfoVO",courseInfoVO);
    }

    //修改课程信息
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@RequestBody CourseInfoVO courseInfoVO){
        courseService.updateCourseInfo(courseInfoVO);

        return R.ok();
    }

    //根据课程id查询课程确认信息
    @GetMapping("/getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable("id")String id){
        CoursePublishVO coursePublishVO = courseService.publishCourseInfo(id);
        return R.ok().data("publishCourse",coursePublishVO);
    }

    //课程最终发布
    //修改课程状态
    @PostMapping("/publishCourse/{id}")
    public R publishCourse(@PathVariable("id")String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        courseService.updateById(eduCourse);
        return R.ok();
    }

    //删除课程
    @DeleteMapping("/{courseId}")
    public R deleteCoyrse(@PathVariable("courseId")String courseId){
        courseService.removeCourse(courseId);
        return R.ok();
    }

    //根据课程id查询课程信息
    @PostMapping("/getCourseInfoOrder/{id}")
    public CourseWebVoOrder getCourseInfoOrder(@PathVariable("id")String id){
        CourseWebVo courseWebVo = courseService.getBaseCourseInfo(id);
        CourseWebVoOrder courseWebVoOrder = new CourseWebVoOrder();
        BeanUtils.copyProperties(courseWebVo,courseWebVoOrder);
        return courseWebVoOrder;
    }

}

