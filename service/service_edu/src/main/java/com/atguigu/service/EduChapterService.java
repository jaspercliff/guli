package com.atguigu.service;

import com.atguigu.common_utils.R;
import com.atguigu.pojo.EduChapter;
import com.atguigu.pojo.dto.chapter.ChapterDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 21903
* @description 针对表【edu_chapter(课程)】的数据库操作Service
* @createDate 2023-05-23 15:45:50
*/
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterDto> getChapterVideByCourseId(String courseId);

     R<Integer> deleteChapter(String chapterId);

    void removeByCourseId(String courseId);
}
