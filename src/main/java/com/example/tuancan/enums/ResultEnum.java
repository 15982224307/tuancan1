package com.example.tuancan.enums;

import lombok.Getter;

/**
 * 结果类型枚举
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),
    ERROR(404,"失败"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
