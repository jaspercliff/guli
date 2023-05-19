package com.atguigu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.listener.EduSubjectListener;
import com.atguigu.pojo.excel.ExcelSubjcet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.pojo.EduSubject;
import com.atguigu.service.EduSubjectService;
import com.atguigu.mapper.EduSubjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
* @author jasper
* @description 针对表【edu_subject(课程科目)】的数据库操作Service实现
* @createDate 2023-05-15 17:21:55
*/
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject>
    implements EduSubjectService{

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, ExcelSubjcet.class,new EduSubjectListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}




