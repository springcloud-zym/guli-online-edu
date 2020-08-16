package com.atguigu.staservice.schedule;

import com.atguigu.staservice.service.StatisticsDailyService;
import com.atguigu.staservice.utils.DateUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author
 * @date 2020/7/23-21:50
 */
@Component
public class ScheduledTask {
    @Autowired
    private StatisticsDailyService staService;

    @Test
    //@Scheduled(cron = "0/5 * * * * ?") //每隔5秒执行一次task1这个方法
    public void task1(){
        System.out.println("********task1执行了********");
    }

    //每天凌晨1点执行,统计前一天的数据
    @Scheduled(cron = "0 0 1 * * ? ")
    public void task2(){
        staService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(),-1)));
    }
}
