package com.atguigu.staservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.staservice.client.UcenterClient;
import com.atguigu.staservice.service.StatisticsDailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-07-23
 */
@CrossOrigin
@RestController
@RequestMapping("/staservice/statistics")
public class StatisticsDailyController {

    @Autowired
    private StatisticsDailyService staService;

    //统计某一天的注册人数,生成统计数据
    @PostMapping("/registerCount/{day}")
    public R registerCount(@PathVariable("day")String day){
        staService.registerCount(day);
        return R.ok();
    }

    //图表显示,返回两部分数据,日期json数组,数量json数组
    @GetMapping("/showData/{type}/{begin}/{end}")
    public R showData(@PathVariable("type")String type,
                      @PathVariable("begin")String begin,
                      @PathVariable("end")String end){
        Map<String,Object> map = staService.getShowData(type,begin,end);
        return R.ok().data(map);
    }

}

