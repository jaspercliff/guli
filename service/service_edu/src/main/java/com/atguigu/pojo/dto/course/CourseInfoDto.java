package com.atguigu.pojo.dto.course;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author jasper
 * 5/23/2023  3:53 PM
 */
@Data
public class CourseInfoDto {
    /**
     * 课程ID
     */
    @TableId(value = "id")
    private String id;
    /**
     * 课程讲师ID
     */
    @TableField(value = "teacher_id")
    private String teacherId;

    /**
     * 课程专业ID
     */
    @TableField(value = "subject_id")
    private String subjectId;

    /**
     * 课程标题
     */
    @TableField(value = "title")
    private String title;
    /**
     * 课程专业父级ID
     */
    @TableField(value = "subject_parent_id")
    private String subjectParentId;
    /**
     * 课程销售价格，设置为0则可免费观看
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 总课时
     */
    @TableField(value = "lesson_num")
    private Object lessonNum;

    /**
     * 课程封面图片路径
     */
    @TableField(value = "cover")
    private String cover;
    /**
     * 课程描述
     */
    private String description;
}
