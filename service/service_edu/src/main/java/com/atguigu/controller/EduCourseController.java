package com.atguigu.controller;

import com.atguigu.common_utils.OssUploadUtil;
import com.atguigu.common_utils.R;
import com.atguigu.pojo.EduCourse;
import com.atguigu.pojo.dto.course.CourseInfoDto;
import com.atguigu.pojo.dto.course.CoursePublishDto;
import com.atguigu.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author jasper
 * 5/23/2023  3:48 PM
 */
@RestController
@RequestMapping("/eduservice/course")
public class EduCourseController {
    private final EduCourseService eduCourseService;

    public EduCourseController(EduCourseService eduCourseService) {
        this.eduCourseService = eduCourseService;
    }

    /**
     * add course
     * @param courseInfoDTO course info
     * @return course id
     */
    @PostMapping("/add")
    private R<String> addCourseInfo(@RequestBody CourseInfoDto courseInfoDTO){
        return eduCourseService.addCourseInfo(courseInfoDTO);
    }

    /**
     * upload course cover
     * @param file cover
     * @return aliYun oss address
     */
    @PostMapping("/upload")
    private R<String> uploadCover( MultipartFile file){
        return R.success(OssUploadUtil.upload(file));
    }

    /**
     * get course info by id  点击上一步跳回去的时候
     * @param courseId course id
     * @return course info and course description
     */
    @GetMapping("/getCourseInfo/{courseId}")
    private CourseInfoDto getCourseInfoById(@PathVariable String courseId){
        return eduCourseService.getCourseInfoById(courseId);
    }

    /**
     * update course info 点击上一步跳回去修改
     * @param courseInfoDto course info
     * @return is success
     */
    @PutMapping("/updateCourseInfo")
    private Boolean updateCourseInfo(@RequestBody CourseInfoDto courseInfoDto){
        return eduCourseService.updateCourseInfo(courseInfoDto);
    }

    @GetMapping("getPublishCourseInfo/{id}")
    private CoursePublishDto getPublishCourseInfo(@PathVariable String id){
        return eduCourseService.getPublishCourseInfo(id);
    }
    @PutMapping("publishCourse/{courseId}")
    private R publishCourse(@PathVariable String courseId){
        eduCourseService.update(new LambdaUpdateWrapper<EduCourse>().eq(EduCourse::getId,courseId).set(EduCourse::getStatus,"Normal"));
        return R.success();
    }

    /**
     * 对课程进行分页查询 status = normal
     * @param current
     * @param limit
     * @return
     */
    @PostMapping("pageCourse/{current}/{limit}")
    private Page<EduCourse> pageTeacher(@PathVariable("current") long current,
                                        @PathVariable("limit") long limit) {
        return eduCourseService.page(new Page<EduCourse>(current,limit),null);
    }

    @GetMapping("pageCourseCondition/{current}/{limit}/{isNormal}")
    private Page<EduCourse> pageCourseCondition(
            @PathVariable long current,
            @PathVariable long limit,
            @PathVariable String isNormal){
        return eduCourseService.getCourseCondition(current,limit,isNormal);
    }

    @DeleteMapping("deleteCourse/{courseId}")
    private R<?> deleteCourse(@PathVariable String courseId){
        return eduCourseService.removeCourse(courseId);
    }
}
