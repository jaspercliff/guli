package com.atguigu.Controller;

import com.atguigu.common_utils.Result;
import com.atguigu.service.EduSubjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author jasper
 * @date 2023/5/15
 */
@RestController
@RequestMapping("/eduservice/subject")
public class EduSubjectController {
    @Resource
    private EduSubjectService eduSubjectService;

    @PostMapping("/addsubject")
    public Result addSubject(MultipartFile file) {
        eduSubjectService.saveSubject(file,eduSubjectService);
        return Result.success();
    }
//    @GetMapping("getAllSubject")
//    public Result getAllSubject(){
//
//    }
}
