package com.atguigu.service;

import com.atguigu.common_utils.R;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jasper
 * 6/1/2023  1:31 PM
 */
public interface VodService {
    R<String> upload(MultipartFile file);

    R<?> deleteVideo(String videoId);

    void deleteBatch(List<String> videoIdList);
}
