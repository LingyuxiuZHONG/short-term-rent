package com.example.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookingStatus {
    PENDING_PAYMENT(0, "待支付"),
    CONFIRMED(1, "已支付"),
    CANCELLED(2, "已取消"),
    COMPLETED(3, "已完成"),
    REFUNDED(4, "已退款");

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
