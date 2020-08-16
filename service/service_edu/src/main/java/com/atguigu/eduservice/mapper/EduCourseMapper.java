package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.frontvo.CourseWebVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-07-17
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVO getPublishCourseInfo(String courseId);

    CourseWebVo getBaseCourseInfo(String courseId);
}
