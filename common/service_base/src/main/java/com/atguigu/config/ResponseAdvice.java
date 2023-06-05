package com.atguigu.config;

import com.atguigu.common_utils.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

/**
 * @author jasper
 * @date 2023/5/5
 */
@RestControllerAdvice("com.atguigu")
public class ResponseAdvice implements  ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof R) {
            return body;
        }
        if(body instanceof Page){
            HashMap<Object, Object> map = new HashMap<>();
            Page<?> page = (Page<?>) body;
            map.put("total",page.getTotal());
            map.put("records",page.getRecords());
            map.put("current",page.getCurrent());
            map.put("size",page.getSize());
            return R.success(map);
        }
        return R.success(body);
    }
}
