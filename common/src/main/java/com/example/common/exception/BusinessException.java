package com.example.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final Integer code;

    public BusinessException(String message) {
        super(message);
        this.code = 400; // 默认 HTTP 400 错误
    }

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}