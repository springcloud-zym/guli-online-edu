package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-07-14
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        baseMapper.selectPage(pageTeacher,wrapper);
        //把分页的数据获取出来,放到map中
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", pageTeacher.getRecords());
        map.put("current", pageTeacher.getCurrent());
        map.put("pages", pageTeacher.getPages());
        map.put("size", pageTeacher.getSize());
        map.put("total", pageTeacher.getTotal());
        map.put("hasNext", pageTeacher.hasNext());
        map.put("hasPrevious", pageTeacher.hasPrevious());
        return map;
    }
}
