package com.atguigu.controller;

import com.atguigu.common_utils.R;
import com.atguigu.pojo.dto.subject.OneSubject;
import com.atguigu.service.EduSubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jasper
 * @date 2023/5/15
 */
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {
    @Resource
    private EduSubjectService eduSubjectService;

    /**
     * add subject category
     * @param file excel
     * @return result
     */
    @PostMapping("/addsubject")
    public R<?> addSubject(MultipartFile file) {
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.success();
    }
/**
 * 课程分类列表
 */
@GetMapping("/getAllSubject")
    public List<OneSubject> getAllSubject(){
        return eduSubjectService.getAllSubject();
}

//    @GetMapping("getAllSubject")
//    public R getAllSubject(){
//
//    }
}
