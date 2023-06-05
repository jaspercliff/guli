package com.atguigu.controller;

import com.atguigu.common_utils.R;
import com.atguigu.pojo.EduChapter;
import com.atguigu.pojo.dto.chapter.ChapterDto;
import com.atguigu.service.EduChapterService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jasper
 * 5/26/2023  9:06 AM
 */
@Data
@RestController
@RequestMapping("/eduservice/chapter")
public class EduChapterController {
    private final EduChapterService eduChapterService;

    public EduChapterController(EduChapterService eduChapterService) {
        this.eduChapterService = eduChapterService;
    }

    /**
     * get all chapter and video
     * @param courseId courseId
     * @return List<ChapterDto>
     */
    @GetMapping("getChapterVideo/{courseId}")
    private List<ChapterDto> getChapterVideo(@PathVariable String courseId){
       return eduChapterService.getChapterVideByCourseId(courseId);
    }

    /**
     * add chapter
     * @param eduChapter  chapter object
     * @return is success
     */
    @PostMapping("addChapter")
    private Boolean addChapter(@RequestBody EduChapter eduChapter){
        return eduChapterService.save(eduChapter);
    }
    @GetMapping("getChapterById/{chapterId}")
    private EduChapter getEduChapterById(@PathVariable  String chapterId){
        return eduChapterService.getById(chapterId);
    }

    @PutMapping("updateChapter")
    private Boolean updateChapter(@RequestBody EduChapter eduChapter){
        return eduChapterService.updateById(eduChapter);
    }

    @DeleteMapping("deleteChapter/{chapterId}")
    private R<Integer> deleteChapter(@PathVariable String chapterId){
        return eduChapterService.deleteChapter(chapterId);
    }
}
