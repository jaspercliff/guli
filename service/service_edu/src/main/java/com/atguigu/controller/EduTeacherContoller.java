package com.atguigu.controller;

import com.atguigu.common_utils.OssUploadUtil;
import com.atguigu.common_utils.R;
import com.atguigu.pojo.EduTeacher;
import com.atguigu.pojo.dto.teacher.TeacherQuery;
import com.atguigu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * @author jasper
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherContoller {
    private final EduTeacherService teacherService;


    public EduTeacherContoller(EduTeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("upload")
    public R<String> uploadImage(@RequestParam("file") MultipartFile file){
        String filePath = OssUploadUtil.upload(file);
        return R.success(filePath);
    }
    /**
     * 添加讲师
     *
     * @param teacher 讲师信息 object
     * @return 是否成功
     */
    @ApiOperation("添加讲师")
    @PostMapping("addTeacher")
    public Boolean addTeacher(@RequestBody EduTeacher teacher) {
        return teacherService.save(teacher);
    }

    @ApiOperation("删除指定的讲师")
    @DeleteMapping("/{id}")
    public R<Boolean> removeTeacher(
            @ApiParam(name = "id", value = "讲师id", required = true)
            @PathVariable String id) {
        return R.success(teacherService.removeById(id));
    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("/getTeacherById/{id}")
    public EduTeacher getTeacherById(@PathVariable("id") String id) {
        return teacherService.getById(id);
    }

    @ApiOperation("修改讲师")
    @PutMapping("/updateTeacher")
    public Boolean updateTeacher(@RequestBody EduTeacher teacher) {
        return teacherService.updateById(teacher);
    }


    @ApiOperation("查询所有讲师")
    @GetMapping("/findAll")
    public List<EduTeacher> findAll() {
//        try {
//            int i = 10/0;
//        } catch (Exception e) {
//            throw new CustomException(2005,"自定义异常"+e.getMessage());
//        }
        return teacherService.list(null);
    }

    @ApiOperation("对讲师进行分页查询")
    @GetMapping("pageTeacher/{current}/{limit}")
    public Page<EduTeacher> pageTeacher(@PathVariable("current") long current,
                                        @PathVariable("limit") long limit) {
        return teacherService.pageTeacher(current, limit);
    }

    @ApiOperation("对讲师进行分页条件查询")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public Page<EduTeacher> pageTeacherCondition(
            @PathVariable("current") long current,
            @PathVariable("limit") long limit,
            @RequestBody(required = false) TeacherQuery teacherQuery) {
        return teacherService.pageTeacherCondition(current, limit, teacherQuery);
    }


}