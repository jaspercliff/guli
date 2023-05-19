package com.atguigu.service;

import com.atguigu.pojo.EduTeacher;
import com.atguigu.pojo.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author jasper
* @description 针对表【edu_teacher(讲师)】的数据库操作Service
* @createDate 2023-05-04 08:56:13
*/
public interface EduTeacherService extends IService<EduTeacher> {

    Page<EduTeacher> pageTeacher(long current, long limit);

    Page<EduTeacher> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery);
}

