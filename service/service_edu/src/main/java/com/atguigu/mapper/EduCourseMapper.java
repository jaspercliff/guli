package com.atguigu.mapper;

import com.atguigu.pojo.EduCourse;
import com.atguigu.pojo.dto.course.CoursePublishDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 21903
* @description 针对表【edu_course(课程)】的数据库操作Mapper
* @createDate 2023-05-23 15:44:54
* @Entity com.atguigu.pojo.EduCourse
*/
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishDto getPublishCourseInfo(String id);
}




