package com.example.payment_service.service;

import com.example.payment_service.config.RazorpayClientConfig;
import com.example.payment_service.dtos.PaymentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import java.time.Instant;



@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private RazorpayClientConfig razorpayClientConfig;
    @Override
    public String generatePaymentLink(PaymentRequestDto paymentRequestDto) throws RazorpayException {
        //todo:  insert the request DTO as a new payment inside the payment service DB -> payment table with status INPROGRESS
        RazorpayClient razorpay = razorpayClientConfig.getRazorpayClient();
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDto.getAmount());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() + 600000);
        paymentLinkRequest.put("reference_id", paymentRequestDto.getOrderId());
        paymentLinkRequest.put("description", paymentRequestDto.getDescription());
        JSONObject customer = new JSONObject();
        customer.put("name", paymentRequestDto.getCustomerName());
        customer.put("contact",paymentRequestDto.getCustomerPhone());
        customer.put("email",paymentRequestDto.getCustomerEmail());
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("reminder_enable",true);
        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}
