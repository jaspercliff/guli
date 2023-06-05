package com.atguigu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.common_utils.R;
import com.atguigu.config.CustomException;
import com.atguigu.feign.VodClient;
import com.atguigu.mapper.EduCourseMapper;
import com.atguigu.pojo.EduCourse;
import com.atguigu.pojo.EduCourseDescription;
import com.atguigu.pojo.EduVideo;
import com.atguigu.pojo.dto.course.CourseInfoDto;
import com.atguigu.pojo.dto.course.CoursePublishDto;
import com.atguigu.service.EduChapterService;
import com.atguigu.service.EduCourseDescriptionService;
import com.atguigu.service.EduCourseService;
import com.atguigu.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 21903
* @description 针对表【edu_course(课程)】的数据库操作Service实现
* @createDate 2023-05-23 15:44:54
*/
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse>
    implements EduCourseService{
    private final EduCourseDescriptionService eduCourseDescriptionService;
    private final EduVideoService videoService;
    private final EduChapterService chapterService;

    public EduCourseServiceImpl(EduCourseDescriptionService eduCourseDescriptionService, EduVideoService videoService, EduChapterService chapterService, EduCourseDescriptionService courseDescService, VodClient vodClient) {
        this.eduCourseDescriptionService = eduCourseDescriptionService;
        this.videoService = videoService;
        this.chapterService = chapterService;
    }



    @Override
    @Transactional
    public R<String> addCourseInfo(CourseInfoDto courseInfoDTO) {
//        edu_course
        EduCourse eduCourse = new EduCourse();
        BeanUtil.copyProperties(courseInfoDTO,eduCourse);
        int isSuccess = baseMapper.insert(eduCourse);
//        执行插入操作后 会自动将id的值设置到eduCourse中
        if (isSuccess==0) {
            throw new CustomException(2005,"添加课程失败");
        }
        String courseId = eduCourse.getId();
//edu_course_description
        EduCourseDescription desc = new EduCourseDescription();
        desc.setDescription(courseInfoDTO.getDescription());
        desc.setId(courseId);
        boolean isTrue = eduCourseDescriptionService.save(desc);
        if(!isTrue){
            throw  new CustomException(2005,"添加课程描述失败");
        }
        return R.success(courseId);
    }

    @Override
    public CourseInfoDto getCourseInfoById(String courseId) {
        EduCourse eduCourse = baseMapper.selectById(courseId);
        EduCourseDescription desc = eduCourseDescriptionService.getById(courseId);
        CourseInfoDto courseInfoDto = new CourseInfoDto();
        BeanUtil.copyProperties(eduCourse,courseInfoDto);
        courseInfoDto.setDescription(desc.getDescription());
        return courseInfoDto;
    }

    @Override
    public Boolean updateCourseInfo(CourseInfoDto courseInfoDto) {
        EduCourse eduCourse = new EduCourse();
        BeanUtil.copyProperties(courseInfoDto,eduCourse);
//        update eduCourse
        int i = baseMapper.updateById(eduCourse);
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseInfoDto.getId());
        eduCourseDescription.setDescription(courseInfoDto.getDescription());
//        update eduCourseDescription
        return eduCourseDescriptionService.updateById(eduCourseDescription);
    }

    @Override
    public CoursePublishDto getPublishCourseInfo(String id) {
        return baseMapper.getPublishCourseInfo(id);
    }

    @Override
    public Page<EduCourse> getCourseCondition(long current, long limit, String isNormal) {
        Page<EduCourse> eduCoursePage = new Page<>();
        return this.page(eduCoursePage,
                new LambdaQueryWrapper<EduCourse>().eq(EduCourse::getStatus,isNormal));
    }

    @Override
    public R<?> removeCourse(String courseId) {
//        删除小节
            videoService.removeByCourseId(courseId);
//        删除章节
        chapterService.removeByCourseId(courseId);
//        删除描述  the desc id = course id
        eduCourseDescriptionService.removeById(courseId);
//        删除课程
        baseMapper.deleteById(courseId);
        return R.success();
    }
}




