package com.atguigu.controller;

import com.aliyuncs.utils.StringUtils;
import com.atguigu.common_utils.R;
import com.atguigu.feign.VodClient;
import com.atguigu.pojo.EduVideo;
import com.atguigu.service.EduVideoService;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author jasper
 * 5/29/2023  1:35 PM
 */

@Controller
@ResponseBody
@RequestMapping("/eduservice/video")
public class EduVideoController {
    private final EduVideoService videoService;
    private final VodClient vodClient;
    public EduVideoController(EduVideoService videoService, VodClient vodClient) {
        this.videoService = videoService;
        this.vodClient = vodClient;
    }
    /**
     * add video
     * @param eduVideo video object
     * @return R
     */
    @PostMapping("addVideo")
    private R<String> addVideo(@RequestBody EduVideo eduVideo){
        videoService.save(eduVideo);
        return R.success("add success!!!");
    }
    @DeleteMapping("deleteVideo/{videoId}")
    private R<?> deleteVideo(@PathVariable String videoId){
        EduVideo video = videoService.getById(videoId);
        String videoSourceId = video.getVideoSourceId();
        videoService.removeById(videoId);
        if(!StringUtils.isEmpty(videoSourceId)){
            vodClient.deleteVideo(videoSourceId);
        }
        return R.success();
    }
    @PutMapping("updateVideo")
    private Boolean updateVideo(@RequestBody EduVideo eduVideo){
        return videoService.updateById(eduVideo);
    }

    @GetMapping("getVideoById/{videoId}")
    private EduVideo getVideoById(@PathVariable String videoId){
        return videoService.getById(videoId);
    }
}
