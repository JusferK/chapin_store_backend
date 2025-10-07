package com.chapinstore.service;

import com.chapinstore.common.mapper.PaymentMapper;
import com.chapinstore.dto.payment.response.PaymentRetrieveDto;
import com.chapinstore.dto.payment.request.PaymentCreationRequestDto;
import com.chapinstore.dto.payment.response.PaymentCreationResponseDto;
import com.chapinstore.dto.payment.response.PaymentRetrieveDtoV2;
import com.chapinstore.entity.Customer;
import com.chapinstore.entity.Payment;
import com.chapinstore.exception.throwable.PaymentSecurityCompromisedException;
import com.chapinstore.repository.PaymentRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PaymentCreationResponseDto create(PaymentCreationRequestDto paymentCreation) {

        customerService.find(paymentCreation.getCustomerEmail());

        paymentRepository.findByCardNumber(paymentCreation.getCardNumber())
                .ifPresent(existingPayment -> {
                    throw new EntityExistsException("Este metodo se encuentra duplicado");
                });

        //ASEGURAR NUMERACION, CVV Y FECHA CON EL BCryptPasswordEncoder

        Payment convertedPayment = paymentMapper.toPayment(paymentCreation);
        convertedPayment.setCardNumber(passwordEncoder.encode(paymentCreation.getCardNumber()));
        convertedPayment.setCvv(passwordEncoder.encode(paymentCreation.getCvv()));


        String lastFour = getLastFours(paymentCreation.getCardNumber());
        convertedPayment.setLastFourDigits(lastFour);

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

    public Payment findById(Integer paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Metodo de pago no fue encontrado."));
    }

    public void isUserPaymentMethodOwner(String email, Integer paymentId) {

        Customer findCustomer = customerService.find(email);
        Payment findPayment = findById(paymentId);

        if (!findPayment.getCustomerEmail().equals(findCustomer.getEmail()))
            throw new PaymentSecurityCompromisedException("Parece que no eres el dueño de este metodo de pago.");
    }

    public Map<String, Boolean> delete(Integer paymentId) {

        Optional<Payment> payment = paymentRepository.findById(paymentId);
        if (payment.isEmpty()) return Map.of("deleted", Boolean.FALSE);

        paymentRepository.delete(payment.get());
        return Map.of("deleted", Boolean.TRUE);
    }

    public String getLastFours(String cardNumber) {
        return cardNumber.substring(12, 16);
    }

    public PaymentRetrieveDtoV2 findAndMap(Integer paymentId) {
        return paymentMapper
                .toPaymentRetrieveDtoV2(
                        findById(paymentId)
                );
    }

}
