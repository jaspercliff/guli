package com.atguigu.controller;

import com.atguigu.common_utils.R;
import com.atguigu.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jasper
 * 6/1/2023  1:28 PM
 */
@RestController
@RequestMapping("/eduvideo")
public class VodController {
    private final VodService vodService;

    public VodController(VodService vodService) {
        this.vodService = vodService;
    }

    @PostMapping("uploadVod")
    private R<String> upload(@RequestPart("file") MultipartFile file){
        return vodService.upload(file);
    }

    @DeleteMapping("deleteVideo/{videoId}")
    private R<?> deleteVideo(@PathVariable String videoId){
        return vodService.deleteVideo(videoId);
    }

    @DeleteMapping("deleteBatch")
    private R<?> deleteBatch(@RequestParam("videoIdList") List<String> videoIdList){
        vodService.deleteBatch(videoIdList);
        return R.success();
    }
}
