package com.atguigu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.atguigu.listener.EduSubjectListener;
import com.atguigu.mapper.EduSubjectMapper;
import com.atguigu.pojo.EduSubject;
import com.atguigu.pojo.dto.subject.OneSubject;
import com.atguigu.pojo.dto.subject.TwoSubject;
import com.atguigu.pojo.excel.ExcelSubjcet;
import com.atguigu.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<OneSubject> getAllSubject() {
        LambdaQueryWrapper<EduSubject> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EduSubject::getParentId,0);
        List<EduSubject> oneSubjects = baseMapper.selectList(wrapper);
        List<EduSubject> twoSubjects = baseMapper.selectList(new LambdaQueryWrapper<EduSubject>().ne(EduSubject::getParentId, "0"));
        ArrayList<OneSubject> finalSubject = new ArrayList<>();
        oneSubjects.forEach(
                eduSubject -> {
//                    确保每次加入的二级分类是空的  要不然会每一个都加一遍
                    ArrayList<TwoSubject> finalTwoSubjectList = new ArrayList<>();
                    OneSubject oneSubject = new OneSubject();
                    BeanUtil.copyProperties(eduSubject,oneSubject);
                    twoSubjects.forEach(eduSubject1 -> {
                        if(eduSubject1.getParentId().equals(oneSubject.getId())){
                            TwoSubject twoSubject = new TwoSubject();
                            BeanUtil.copyProperties(eduSubject1,twoSubject);
                            finalTwoSubjectList.add(twoSubject);
                        }
                    });
                    oneSubject.setChildren(finalTwoSubjectList);
                    finalSubject.add(oneSubject);
                }
        );
        return finalSubject;
    }
}




