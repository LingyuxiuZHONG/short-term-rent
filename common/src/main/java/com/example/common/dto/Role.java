package com.example.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    GUEST(1, "房客"),
    HOST(2,"房东"),
    ADMIN(3,"管理员");

    private final int code;
    private final String description;

}
