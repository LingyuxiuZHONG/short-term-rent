package com.example.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {

    PROCESSING(0, "支付中"),
    SUCCESS(1, "支付成功"),
    FAILED(2, "支付失败"),
    REFUND_SUCCESS(3, "退款成功"),
    REFUND_FAILED(4, "退款失败");

    private final int code;
    private final String description;

    public static PaymentStatus fromCode(int code) {
        for (PaymentStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("无效的支付状态: " + code);
    }
}

