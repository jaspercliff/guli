package com.atguigu.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jasper
 * @date 2023/5/5
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherQuery {

    /**
     * 讲师姓名
     */
    @ApiModelProperty("教师名称 模糊查询")
    private String name;
    @ApiModelProperty("教师头衔 1高级讲师 2首席讲师")
    private Integer level;
    @ApiModelProperty(value = "开始时间",example = "2019-01-04 10:10:10")
    private String begin;
    @ApiModelProperty(value = "结束时间",example = "2019-01-04 10:10:10")
    private String end;

}
