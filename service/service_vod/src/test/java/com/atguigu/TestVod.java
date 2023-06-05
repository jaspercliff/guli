package com.atguigu;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadVideoResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoRequest;
import com.aliyuncs.vod.model.v20170321.GetPlayInfoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import lombok.Data;

import java.util.List;

/**
 * @author jasper
 * 5/31/2023  9:37 PM
 */

public class TestVod {
    public static void main(String[] args) throws ClientException {
            TestVod.testUploadVideo(
                    "LTAI5tHJjeqMBPRPHJ7dYCdn", "RKXP0lIxBaUZJ0DUS0b56qL8uqSooM",
                    "test_video","D:/21903/Videos/test.mp4"
            );
    }

    private static void testUploadVideo(String accessKeyId, String accessKeySecret, String title, String fileName) {
        UploadVideoRequest request = new UploadVideoRequest(accessKeyId, accessKeySecret, title, fileName);
        request.setPartSize(2 * 1024 * 1024L);
        request.setTaskNum(1);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadVideoResponse response = uploader.uploadVideo(request);
        System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else {
            /* 如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因 */
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
    }
        public static void getAuth() throws ClientException {
            DefaultAcsClient client = InitVod.initVodClient("LTAI5tHJjeqMBPRPHJ7dYCdn", "RKXP0lIxBaUZJ0DUS0b56qL8uqSooM");
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            GetVideoPlayAuthResponse response = new GetVideoPlayAuthResponse();
            request.setVideoId("6391f330ffbb71edbfa47035d0b20102");
            response = client.getAcsResponse(request);
            String playAuth = response.getPlayAuth();
            System.out.println("playAuth = " + playAuth);
        }

    public static void getPlayUrl() throws ClientException {
        DefaultAcsClient client = InitVod.initVodClient("LTAI5tHJjeqMBPRPHJ7dYCdn", "RKXP0lIxBaUZJ0DUS0b56qL8uqSooM");
        GetPlayInfoRequest request = new GetPlayInfoRequest();
        GetPlayInfoResponse response = new GetPlayInfoResponse();
        request.setVideoId("e9d48dc0ffb871edbfe20675b3ed0102");
        response = client.getAcsResponse(request);
        List<GetPlayInfoResponse.PlayInfo> playInfoList = response.getPlayInfoList();
        //播放地址
        for (GetPlayInfoResponse.PlayInfo playInfo : playInfoList) {
            System.out.print("PlayInfo.PlayURL = " + playInfo.getPlayURL() + "\n");
        }
        //Base信息
        System.out.print("VideoBase.Title = " + response.getVideoBase().getTitle() + "\n");
    }
}
