package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exception.MyException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-14
 */
@Api(value = "讲师管理")
@RestController
//@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService teacherService;

    //查询讲师表所有数据
    @ApiOperation(value = "查询所有讲师")
    @GetMapping("/findAll")
    public R findAllTeacher(){
        List<EduTeacher> teacherList = teacherService.list(null);
        try {
            //int i = 10/0;
        } catch (Exception e) {
            throw new MyException(20002,"执行了自定义异常处理");
        }
        return R.ok().data("list",teacherList);
    }

    //逻辑删除讲师
    @ApiOperation(value = "逻辑删除讲师")
    @DeleteMapping("{id}")
    public R deleteTeacher(@ApiParam(name = "id",value = "讲师id",required = true) @PathVariable("id")String id){
        boolean b = teacherService.removeById(id);
        if (b == true){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //分页查询讲师
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("/pageTeacher/{page}/{size}")
    public R pageTeacherList(@PathVariable("page")Long page,@PathVariable("size")Long size){
        Page<EduTeacher> pageObj = new Page<>(page,size);
        IPage<EduTeacher> pageTeacher = teacherService.page(pageObj, null);
        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    //条件查询带分页
    @ApiOperation(value = "条件查询带分页")
    @PostMapping("/pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(@PathVariable("current")Long current, @PathVariable("limit")Long limit,
                                  @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> pageObj = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(teacherQuery.getName())){
            wrapper.like("name",teacherQuery.getName());
        }
        if (!StringUtils.isEmpty(teacherQuery.getLevel())){
            wrapper.eq("level",teacherQuery.getLevel());
        }
        if (!StringUtils.isEmpty(teacherQuery.getBegin())){
            wrapper.ge("gmt_create",teacherQuery.getBegin());
        }
        if (!StringUtils.isEmpty(teacherQuery.getEnd())){
            wrapper.le("gmt_create",teacherQuery.getEnd());
        }

        IPage<EduTeacher> teacherPageCondition = teacherService.page(pageObj, wrapper);

        return R.ok().data("pageTeacherCondition",teacherPageCondition);
    }

    //添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if (save == true){
            return R.ok();
        }else {
            return R.error();
        }
    }

    //根据id查询讲师信息
    @ApiOperation(value = "根据id查询讲师信息")
    @GetMapping("/getTeacher/{id}")
    public R getTeacher(@PathVariable("id")String id){
        EduTeacher teacher = teacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }
    //修改讲师信息
    @ApiOperation(value = "修改讲师信息")
    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean b = teacherService.updateById(eduTeacher);
        if (b == true){
            return R.ok();
        }else {
            return R.error();
        }
    }

}

