package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * @date 2023/5/15
 */
public class SimpleWrite {
    public static void main(String[] args) {
        String fileName = "E:\\excel\\01.xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("学生信息").doWrite(SimpleWrite::getData);
    }


    private static List<DemoData> getData(){
        ArrayList<DemoData> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData demoDate = new DemoData();
            demoDate.setSno(i);
            demoDate.setSname("mike"+i);
            data.add(demoDate);
        }
        return data;
    }
}
