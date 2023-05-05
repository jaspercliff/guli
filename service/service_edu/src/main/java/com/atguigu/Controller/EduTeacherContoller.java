package com.atguigu.Controller;

import com.atguigu.common_utils.Result;
import com.atguigu.pojo.EduTeacher;
import com.atguigu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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

@ApiOperation("查询所有讲师")
@GetMapping("/findAll")
public List<EduTeacher> findAll(){
    return teacherService.list(null);
}

@ApiOperation("删除指定的讲师")
@DeleteMapping("/{id}")
    public Result removeTeacher(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable String id){
    return Result.success(teacherService.removeById(id));
}
@ApiOperation("对讲师进行分页查询")
    @GetMapping("pageTeacher/{current}/{limit}")
    public Page<EduTeacher> pageTeacher(@PathVariable("current") long current,
                            @PathVariable("limit") long limit){
    return teacherService.pageTeacher(current,limit);
}

}
