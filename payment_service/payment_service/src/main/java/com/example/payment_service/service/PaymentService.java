package com.example.payment_service.service;

import com.example.payment_service.dtos.PaymentRequestDto;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;


public interface PaymentService {
    String generatePaymentLink(PaymentRequestDto paymentRequestDto) throws RazorpayException;
}
