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
public class Result {
    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("返回状态码")
    private Integer code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private Object data;

    public static  Result success(Object data) {
        return new Result(true,
                ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getMessage(),
                data);
    }

    public static  Result success(String message,Object data) {
        return new Result(true,
                ResultCode.SUCCESS.getCode(),
                message,
                data);
    }

    public static Result fail() {
        return new Result(false,
                ResultCode.COMMON_FAILED.getCode(),
                ResultCode.COMMON_FAILED.getMessage(),
                null);
    }
    public static  Result fail(String message) {
        return new Result(false,
                ResultCode.COMMON_FAILED.getCode(),
                message,
                null);
    }

}
