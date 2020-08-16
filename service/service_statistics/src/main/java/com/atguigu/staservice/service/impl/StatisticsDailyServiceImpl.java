package com.atguigu.staservice.service.impl;

import com.atguigu.staservice.client.UcenterClient;
import com.atguigu.staservice.entity.StatisticsDaily;
import com.atguigu.staservice.mapper.StatisticsDailyMapper;
import com.atguigu.staservice.service.StatisticsDailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-07-23
 */
@Service
public class StatisticsDailyServiceImpl extends ServiceImpl<StatisticsDailyMapper, StatisticsDaily> implements StatisticsDailyService {
    @Autowired
    private UcenterClient ucenterClient;

    @Override
    public void registerCount(String day) {
        //远程调用,得到某一天的注册人数
        Integer countRegister = ucenterClient.countRegister(day);

        //把获取到的数据添加到数据库,统计分析表里
        StatisticsDaily statisticsDaily = new StatisticsDaily();
        statisticsDaily.setRegisterNum(countRegister);//注册人数
        statisticsDaily.setDateCalculated(day);//统计日期

        //模拟获取到的统计数据
        statisticsDaily.setVideoViewNum(RandomUtils.nextInt(100,200));
        statisticsDaily.setLoginNum(RandomUtils.nextInt(100,200));
        statisticsDaily.setCourseNum(RandomUtils.nextInt(100,200));

        //在添加记录之前删除表中相同日期的数据
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.eq("date_calculated",day);
        baseMapper.delete(wrapper);
        baseMapper.insert(statisticsDaily);


    }

    @Override
    public Map<String, Object> getShowData(String type, String begin, String end) {
        //根据条件查询对应的数据
        QueryWrapper<StatisticsDaily> wrapper = new QueryWrapper<>();
        wrapper.between("date_calculated",begin,end);
        wrapper.select("date_calculated",type);
        List<StatisticsDaily> staList = baseMapper.selectList(wrapper);
        //因为返回的有两部分数据
        //日期和日期对应的数据
        //前端要求是json数组,对应后端java代码是list集合
        //创建两个list集合,一个是日期list,一个是数量list
        List<String> date_calculatedList = new ArrayList<>();
        List<Integer> numDataList = new ArrayList<>();
        for (StatisticsDaily statisticsDaily : staList) {
            date_calculatedList.add(statisticsDaily.getDateCalculated());
            switch (type){
                case "register_num":numDataList.add(statisticsDaily.getRegisterNum());
                    break;
                case "login_num":numDataList.add(statisticsDaily.getLoginNum());
                    break;
                case "video_view_num":numDataList.add(statisticsDaily.getVideoViewNum());
                    break;
                case "course_num":numDataList.add(statisticsDaily.getCourseNum());
                    break;
                default:
                    break;

            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("date_calculatedList",date_calculatedList);
        map.put("numDataList",numDataList);
        return map;
    }
}
