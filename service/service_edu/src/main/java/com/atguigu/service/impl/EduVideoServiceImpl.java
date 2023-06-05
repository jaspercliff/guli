package com.atguigu.service.impl;

import com.aliyuncs.utils.StringUtils;
import com.atguigu.feign.VodClient;
import com.atguigu.mapper.EduVideoMapper;
import com.atguigu.pojo.EduVideo;
import com.atguigu.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 21903
* @description 针对表【edu_video(课程视频)】的数据库操作Service实现
* @createDate 2023-05-23 15:46:21
*/
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo>
    implements EduVideoService{

    private final VodClient vodClient;

    public EduVideoServiceImpl(VodClient vodClient) {
        this.vodClient = vodClient;
    }

    /**
     * remove video by course id
     * @param courseId
     */
    @Override
    public void removeByCourseId(String courseId) {
        LambdaQueryWrapper<EduVideo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EduVideo::getCourseId,courseId).select(EduVideo::getVideoSourceId);
        List<EduVideo> eduVideos = baseMapper.selectList(wrapper);
        ArrayList<String> ids = new ArrayList<>();
        eduVideos.forEach(eduVideo -> {
            String videoSourceId = eduVideo.getVideoSourceId();
            if (!StringUtils.isEmpty(videoSourceId)){
                ids.add(videoSourceId);
            }
        });

            vodClient.deleteBatch(ids);
//先删视频在删除小节 otherwise 会查不出eduVideos
        this.remove(new LambdaUpdateWrapper<EduVideo>().eq(EduVideo::getCourseId,courseId));
    }
}




