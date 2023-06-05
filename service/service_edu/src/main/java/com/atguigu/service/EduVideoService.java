package com.atguigu.service;

import com.atguigu.pojo.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 21903
* @description 针对表【edu_video(课程视频)】的数据库操作Service
* @createDate 2023-05-23 15:46:21
*/
public interface EduVideoService extends IService<EduVideo> {

    void removeByCourseId(String courseId);
}
