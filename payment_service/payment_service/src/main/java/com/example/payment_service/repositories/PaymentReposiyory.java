package com.example.payment_service.repositories;

import com.example.payment_service.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReposiyory extends JpaRepository<Payment,Long> {
}
