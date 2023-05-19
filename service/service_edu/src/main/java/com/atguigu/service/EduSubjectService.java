package com.atguigu.service;

import com.atguigu.pojo.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
* @author jasper
* @description 针对表【edu_subject(课程科目)】的数据库操作Service
* @createDate 2023-05-15 17:21:55
*/
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);
}
