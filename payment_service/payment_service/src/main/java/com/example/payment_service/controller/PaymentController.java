package com.example.payment_service.controller;

import com.example.payment_service.dtos.PaymentRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @PostMapping("/payment")//this api will be called by order Service
    private ResponseEntity<String> doPayment(@RequestBody PaymentRequestDto paymentRequestDto){
     //validation for dto
    }
}
