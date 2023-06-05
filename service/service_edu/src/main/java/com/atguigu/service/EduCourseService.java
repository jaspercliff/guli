package com.atguigu.service;

import com.atguigu.common_utils.R;
import com.atguigu.pojo.EduCourse;
import com.atguigu.pojo.dto.course.CourseInfoDto;
import com.atguigu.pojo.dto.course.CoursePublishDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 21903
* @description 针对表【edu_course(课程)】的数据库操作Service
* @createDate 2023-05-23 15:44:54
*/
public interface EduCourseService extends IService<EduCourse> {

    R<String> addCourseInfo(CourseInfoDto courseInfoDTO);

    CourseInfoDto getCourseInfoById(String courseId);

    Boolean updateCourseInfo(CourseInfoDto courseInfoDto);

    CoursePublishDto getPublishCourseInfo(String id);

    Page<EduCourse> getCourseCondition(long current, long limit,String isNormal);

    R<?> removeCourse(String courseId);
}
