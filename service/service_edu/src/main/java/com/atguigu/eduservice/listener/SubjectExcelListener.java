package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exception.MyException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import javax.security.auth.Subject;

/**
 * @author
 * @date 2020/7/17-11:39
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    public EduSubjectService subjectService;

    public SubjectExcelListener() {}
    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //读取excel内容
    @Override
    public void invoke(SubjectData data, AnalysisContext context) {
        if (data == null){
            throw  new MyException(20001,"文件数据为空");
        }

        //一行一行的读取,每次读取两个值,第一个值一级分类,第二个值二级分类
        //判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(subjectService, data.getOneSubjectName());
        if (existOneSubject == null){ //数据表中没有相同的一级分类,进行添加
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(data.getOneSubjectName());
            subjectService.save(existOneSubject);
        }

        //添加二级分类
        //判断二级分类是否重复
        String pid = existOneSubject.getId();
        EduSubject existTowSubject = this.existTowSubject(subjectService, data.getTwoSubjectName(), pid);
        if (existTowSubject == null){
            existTowSubject = new EduSubject();
            existTowSubject.setParentId(pid);
            existTowSubject.setTitle(data.getTwoSubjectName());
            subjectService.save(existTowSubject);
        }

    }

    //判定一级分类不能重复添加
    private EduSubject existOneSubject(EduSubjectService subjectService,String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }

    //判定二级分类不能重复添加
    private EduSubject existTowSubject(EduSubjectService subjectService,String name,String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
