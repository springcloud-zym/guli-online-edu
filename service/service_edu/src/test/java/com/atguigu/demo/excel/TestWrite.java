package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * @date 2020/7/17-11:06
 */

public class TestWrite {
    public static void main(String[] args) {
        //实现excel写操作
        //1.写入文件地址和名称
        String fileName = "F:\\write.xlsx";
        //2.调用easyexcel里面的方法实现写操作
        //第一个参数:文件路径名称
        //第二个参数:实体类
        //sheet()方法表示在excel中的哪个表名
        //doWrite()中的参数是要写入的数据
        EasyExcel.write(fileName,DemoData.class).sheet("学生表").doWrite(getData());

    }

    private static List<DemoData> getData(){
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setSno(i);
            demoData.setSname(i+"同学");
            list.add(demoData);
        }
        return list;
    }
}
