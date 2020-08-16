package com.atguigu.eduservice.entity.vo;

import lombok.Data;

/**
 * @author
 * @date 2020/7/18-22:40
 */
@Data
public class CoursePublishVO {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
