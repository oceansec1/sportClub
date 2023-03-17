package com.sport.demo;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) throws Exception {
        //excel 写的操作
        //设置路径
//        String filename="E:\\bishe\\write.xlsx";
//        //调用Easyexcel 里的方法
//       EasyExcel.write(filename,DemoData.class).sheet("学生信息").doWrite(getData());

        //读取操作
        String filename="E:\\bishe\\write.xlsx";
        EasyExcel.read(filename,DemoData.class,new ExcelListener()).sheet().doRead();
    }
    private static List<DemoData> getData(){
        List<DemoData> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoData=new DemoData();
            demoData.setSno(i);
            demoData.setSname("lucy"+i);
            list.add(demoData);
        }
        return list;
    }
}
