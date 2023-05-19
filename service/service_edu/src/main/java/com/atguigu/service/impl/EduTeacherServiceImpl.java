package com.atguigu.service.impl;

import com.atguigu.pojo.vo.TeacherQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.pojo.EduTeacher;
import com.atguigu.service.EduTeacherService;
import com.atguigu.mapper.EduTeacherMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Page<EduTeacher> pageTeacherCondition(long current, long limit, TeacherQuery teacherQuery) {
        Page<EduTeacher> eduTeacherPage = new Page<>(current,limit);
        LambdaQueryWrapper<EduTeacher> wrapper = new LambdaQueryWrapper<>();
        Optional.ofNullable(teacherQuery.getName()).ifPresent(n ->wrapper.like(EduTeacher::getName,n));
        Optional.ofNullable(teacherQuery.getLevel()).ifPresent(l -> wrapper.eq(EduTeacher::getLevel, l));
        Optional.ofNullable(teacherQuery.getBegin()).ifPresent(begin -> wrapper.ge(EduTeacher::getGmtCreate, begin));
        Optional.ofNullable(teacherQuery.getEnd()).ifPresent(end -> wrapper.le(EduTeacher::getGmtCreate, end));
        wrapper.orderByDesc(EduTeacher::getGmtCreate);
        return this.page(eduTeacherPage, wrapper);
    }
}




