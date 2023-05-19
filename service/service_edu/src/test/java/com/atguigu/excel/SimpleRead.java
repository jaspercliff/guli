package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author jasper
 * @date 2023/5/15
 */
public class SimpleRead {
    public static void main(String[] args) {
        String fileName = "E:\\excel\\01.xlsx";
        EasyExcel.read(fileName, DemoData.class,new DemoDataListenr()).sheet().doRead();
    }
}
