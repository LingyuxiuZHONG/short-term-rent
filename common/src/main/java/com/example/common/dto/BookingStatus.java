package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookingStatus {
    PENDING_PAYMENT(0, "待支付"),
    PROCESSING_PAYMENT(1, "支付中"),
    CONFIRMED(2, "已支付"),
    CANCELLED(3, "已取消"),
    COMPLETED(4, "已完成");

    private final int code;
    private final String description;

    public static BookingStatus fromCode(int code){
        for(BookingStatus status : values()){
            if(status.code == code){
                return status;
            }
        }
        throw new IllegalArgumentException("无效的预订状态： " + code);
    }
}
