package com.atguigu.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.common_utils.R;
import com.atguigu.config.CustomException;
import com.atguigu.mapper.EduChapterMapper;
import com.atguigu.pojo.EduChapter;
import com.atguigu.pojo.EduVideo;
import com.atguigu.pojo.dto.chapter.ChapterDto;
import com.atguigu.pojo.dto.chapter.VideoDto;
import com.atguigu.service.EduChapterService;
import com.atguigu.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 21903
* @description 针对表【edu_chapter(课程)】的数据库操作Service实现
* @createDate 2023-05-23 15:45:50
*/
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter>
    implements EduChapterService{
    private final EduVideoService eduVideoService;

    public EduChapterServiceImpl(EduVideoService eduVideoService) {
        this.eduVideoService = eduVideoService;
    }

    @Override
    public List<ChapterDto> getChapterVideByCourseId(String courseId) {
        List<EduChapter> eduChapters = baseMapper.selectList(new LambdaQueryWrapper<EduChapter>().eq(EduChapter::getCourseId, courseId).orderByDesc(EduChapter::getGmtCreate));
        List<EduVideo> eduVideos = eduVideoService.list(new LambdaQueryWrapper<EduVideo>().eq(EduVideo::getCourseId, courseId));
        ArrayList<ChapterDto> finalList = new ArrayList<>();
        eduChapters.forEach(eduChapter ->{
            ArrayList<VideoDto> finalVideoDtoList = new ArrayList<>();
            ChapterDto chapterDto = new ChapterDto();
            BeanUtil.copyProperties(eduChapter,chapterDto);
            finalList.add(chapterDto);
            eduVideos.forEach( eduVideo -> {
                if(eduVideo.getChapterId().equals( eduChapter.getId())){
                    VideoDto videoDto = new VideoDto();
                    BeanUtil.copyProperties(eduVideo,videoDto);
                    finalVideoDtoList.add(videoDto);
                }
            });
            chapterDto.setChildren(finalVideoDtoList);
        });
        return finalList;
    }

    @Override
    public R<Integer> deleteChapter(String chapterId) {
        long count = eduVideoService.count(new LambdaQueryWrapper<EduVideo>().eq(EduVideo::getCourseId, chapterId));
        if (count > 0) {
            throw new CustomException(2005,"There are subsection under the chapter that cannot be deleted");
        }
        int i = baseMapper.deleteById(chapterId);
        return i>0 ? R.success("删除成功",i): R.fail("删除失败");
    }

    @Override
    public void removeByCourseId(String courseId) {
        this.remove(new LambdaUpdateWrapper<EduChapter>().eq(EduChapter::getCourseId,courseId));
    }
}




