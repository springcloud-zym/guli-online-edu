package com.atguigu.demo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author
 * @date 2020/7/17-11:03
 */
@Data
public class DemoData {

    //设置excel表头名称
    @ExcelProperty(value = "学号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "姓名",index = 1)
    private String sname;
}
