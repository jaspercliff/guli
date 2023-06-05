package com.atguigu.pojo.dto.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * 5/26/2023  9:03 AM
 */
@Data
public class ChapterDto {
    private String id;
    private String title;
    private List<VideoDto> children = new ArrayList<>();
}
