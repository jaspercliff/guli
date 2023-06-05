package com.atguigu.common_utils;

import lombok.Getter;

/**
 * @author jasper
 * @date 2023/5/4
 */
@Getter
public enum ResultCode {
    SUCCESS(2001,"The interface invoke is successful!!!"),
    COMMON_FAILED(2002,"The interface invoke is failed!!!"),
    VALIDATE_FAILED(2003,"validate parament failed!!!"),
    FORBIDEN(2004,"no access!!!");
    private final Integer code;
    private final String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
