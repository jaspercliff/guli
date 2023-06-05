package com.atguigu.pojo.dto.course;

import lombok.Data;

/**
 * @author jasper
 * 5/29/2023  7:58 PM
 */
@Data
public class CoursePublishDto {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String description;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;
}
