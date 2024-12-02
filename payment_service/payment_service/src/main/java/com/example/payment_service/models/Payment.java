package com.example.payment_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="payment")
public class Payment extends BaseModel{
    private double amount;
    private Long userId;
    private Long orderId;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private  PaymentStatus paymentStatus;
    @OneToOne
    private Currency currency;
}
