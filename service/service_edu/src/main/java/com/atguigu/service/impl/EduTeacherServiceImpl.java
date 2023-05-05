package com.atguigu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.pojo.EduTeacher;
import com.atguigu.service.EduTeacherService;
import com.atguigu.mapper.EduTeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author jasper
* @description 针对表【edu_teacher(讲师)】的数据库操作Service实现
* @createDate 2023-05-04 08:56:13
*/
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher>
    implements EduTeacherService{

    @Override
    public Page<EduTeacher> pageTeacher(long current, long limit) {
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        return this.page(teacherPage, null);
    }
}




