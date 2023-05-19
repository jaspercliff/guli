package com.atguigu.common_utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jasper
 * @date 2023/5/4
 */
@Data
@AllArgsConstructor
public class Result<T> {
    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("返回状态码")
    private Integer code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private T data;
    public static <T>  Result<T> success(T data) {
        return new Result<>(true,
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),
                data);
    }

    public static <T>  Result<T> success() {
        return new Result<>(true,
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),
                null);
    }

    public static <T> Result<T> success(String message,T data) {
        return new Result<T>(true,
                ResultCode.SUCCESS.getCode(),
                message,
                data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(false,
                ResultCode.COMMON_FAILED.getCode(),
                ResultCode.COMMON_FAILED.getMessage(),
                null);
    }
    public static <T> Result<T> fail(String message) {
        return new <T> Result<T>(false,
                ResultCode.COMMON_FAILED.getCode(),
                message,
                null);
    }

    public static <T> Result<T> fail(Integer code,String message) {
        return new <T> Result<T>(false,
                code,
                message,
                null);
    }


}
