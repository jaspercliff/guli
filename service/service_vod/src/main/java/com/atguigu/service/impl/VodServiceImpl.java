package com.atguigu.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.atguigu.common_utils.R;
import com.atguigu.config.CustomException;
import com.atguigu.config.SystemConstant;
import com.atguigu.service.VodService;
import com.atguigu.utils.InitVod;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jasper
 * 6/1/2023  1:31 PM
 */
@Service
public class VodServiceImpl implements VodService {

    @Override
    public R<String> upload(MultipartFile file){
        String accessKeyId = SystemConstant.keyId;
        String accessKeySecret = SystemConstant.keySecret;
        String fileName = file.getOriginalFilename();
        String title = null;
        if (fileName != null) {
            title = fileName.substring(0, fileName.lastIndexOf("."));
        }
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret, title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = "";
            videoId = response.getVideoId();
            return R.success(videoId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public R<?> deleteVideo(String videoId) {
        DefaultAcsClient client = InitVod.initVodClient(
                SystemConstant.keyId,
                SystemConstant.keySecret
        );
        DeleteVideoRequest  request = new DeleteVideoRequest();
        request.setVideoIds(videoId);
        try {
            DeleteVideoResponse acsResponse = client.getAcsResponse(request);
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            throw new CustomException(2005,"删除失败");
        }
        return R.success();
    }

    @Override
    public void deleteBatch(List<String> videoIdList) {
        DefaultAcsClient client = InitVod.initVodClient(
                SystemConstant.keyId,
                SystemConstant.keySecret
        );
        DeleteVideoRequest  request = new DeleteVideoRequest();
        String join = String.join(",", videoIdList);
        request.setVideoIds(join);
        try {
            DeleteVideoResponse acsResponse = client.getAcsResponse(request);
        } catch (ClientException e) {
            System.out.println(e.getMessage());
            throw new CustomException(2005,"删除失败");
        }
    }

     public static void main(String[] args) {
         ArrayList<String> strings = new ArrayList<>();
         strings.add("11");
         strings.add("22");
         strings.add("33");
         strings.add("44");
         String join = String.join(",", strings);
         System.out.println("join = " + join);
     }
}
