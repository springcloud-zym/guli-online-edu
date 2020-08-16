package com.atguigu.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2020/7/17-15:18
 * 一级分类
 */
@Data
public class OneSubject {
    private String id;
    private String title;
    List<TwoSubject> children = new ArrayList<>();

}
