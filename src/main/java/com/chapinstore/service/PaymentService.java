package com.chapinstore.service;

import com.chapinstore.common.mapper.PaymentMapper;
import com.chapinstore.dto.order_request.response.PaymentRetrieveDto;
import com.chapinstore.dto.payment.request.PaymentCreationRequestDto;
import com.chapinstore.dto.payment.response.PaymentCreationResponseDto;
import com.chapinstore.entity.Customer;
import com.chapinstore.entity.Payment;
import com.chapinstore.repository.PaymentRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentMapper paymentMapper;

    public PaymentCreationResponseDto create(PaymentCreationRequestDto paymentCreation) {

        paymentRepository.findByCardNumber(paymentCreation.getCardNumber())
                .orElseThrow(() -> new EntityExistsException("Este metodo se encuentra duplicado"));

        //ASEGURAR NUMERACION, CVV Y FECHA CON EL BCryptPasswordEncoder

        Payment convertedPayment = paymentMapper.toPayment(paymentCreation);
        paymentRepository.save(convertedPayment);

        return paymentMapper.toPaymentCreationResponseDto(convertedPayment);
    }

    public List<PaymentRetrieveDto> find(String customerEmail) {

        Customer findCustomer = customerService.find(customerEmail);
        List<Payment> payments = paymentRepository.findByCustomerEmail(findCustomer.getEmail());

        return payments
                .stream()
                .map(payment -> paymentMapper.toPaymentRetrieveDto(payment))
                .toList();
    }

    public Map<String, Boolean> delete(Integer paymentId) {

        Optional<Payment> payment = paymentRepository.findById(paymentId);
        if (payment.isEmpty()) return Map.of("deleted", Boolean.FALSE);

        paymentRepository.delete(payment.get());
        return Map.of("deleted", Boolean.TRUE);
    }



}
