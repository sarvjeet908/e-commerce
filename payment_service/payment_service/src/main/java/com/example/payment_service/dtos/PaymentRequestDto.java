package com.example.payment_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PaymentRequestDto {
    private Long amount;
    private String orderId;
    private String description;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
}
