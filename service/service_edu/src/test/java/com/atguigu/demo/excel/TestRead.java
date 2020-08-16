package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author
 * @date 2020/7/17-11:25
 */
public class TestRead {
    public static void main(String[] args) {
        //要读的文件
        String fileName = "F:\\write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }
}
