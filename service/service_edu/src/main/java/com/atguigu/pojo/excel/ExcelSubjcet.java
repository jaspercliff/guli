package com.atguigu.pojo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jasper
 * @date 2023/5/15
 */
@Data
public class ExcelSubjcet {
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twosubjectName;
}
