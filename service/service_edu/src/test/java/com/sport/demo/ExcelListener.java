package com.sport.demo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.util.ConverterUtils;

import java.util.Map;

public class ExcelListener extends AnalysisEventListener<DemoData> {
    //一行一行读取excel内容
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println("****"+demoData);
    }
    //读取表头
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        System.out.println("表头"+headMap);
    }

    //读取完之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
