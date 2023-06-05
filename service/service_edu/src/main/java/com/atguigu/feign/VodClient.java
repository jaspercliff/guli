package com.atguigu.feign;

import com.atguigu.common_utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 21903
 */
@FeignClient("service-vod")
@Component
public interface VodClient {
//    定义调用方法的路径
//    @pathvar 一定要指定参数
    @DeleteMapping("/eduvideo/deleteVideo/{videoId}")
    public R<?> deleteVideo(@PathVariable("videoId") String videoId);
    @DeleteMapping("/eduvideo/deleteBatch")
    public R<?> deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);
}
