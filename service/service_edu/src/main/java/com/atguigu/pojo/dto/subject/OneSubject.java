package com.atguigu.pojo.dto.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * 5/22/2023  10:01 PM
 */
@Data
public class OneSubject {
    private String id;
    private String title;
    private List<TwoSubject> children = new ArrayList<>();
}
