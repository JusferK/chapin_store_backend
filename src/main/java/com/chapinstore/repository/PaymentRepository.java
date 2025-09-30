package com.chapinstore.repository;

import com.chapinstore.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    public Optional<Payment> findByCardNumber(String cardNumber);
    public List<Payment> findByCustomerEmail(String email);
}