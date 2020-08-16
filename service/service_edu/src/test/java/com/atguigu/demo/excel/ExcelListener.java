package com.atguigu.demo.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author
 * @date 2020/7/17-11:21
 */
public class ExcelListener extends AnalysisEventListener<DemoData> {

    //一行一行的读取excel内容
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("****"+demoData);
    }

    //读取表头中的内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("标题:"+headMap);
    }

    //读取完成之后做的事情
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {}
}
