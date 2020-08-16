package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-17
 */
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/subject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService subjectService;

    //添加课程分类
    //获取到上传过来的文件,把文件内容读取出来
    @PostMapping("/addSubject")
    public R addSubject(MultipartFile file){
        //上传过来的excel文件
        subjectService.saveSubject(file,subjectService);

        return R.ok();
    }

    //课程分类列表(树形)
    @GetMapping("/getAllSubject")
    public R getAllList(){
        List<OneSubject> list = subjectService.getAllOneTwoSubject();


        return R.ok().data("list",list);
    }

}

