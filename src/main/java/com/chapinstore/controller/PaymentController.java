package com.chapinstore.controller;

import com.chapinstore.dto.order_request.response.PaymentRetrieveDto;
import com.chapinstore.dto.payment.request.PaymentCreationRequestDto;
import com.chapinstore.dto.payment.response.PaymentCreationResponseDto;
import com.chapinstore.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentCreationResponseDto> create(
            @Valid @RequestBody PaymentCreationRequestDto paymentCreationRequestDto
    ) {
        return ResponseEntity
                .ok(paymentService.create(paymentCreationRequestDto));
    }

    @GetMapping("/find")
    public ResponseEntity<List<PaymentRetrieveDto>> find(
            @RequestParam String email
    ) {
        return ResponseEntity.ok(paymentService.find(email));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(
            @RequestParam Integer paymentId
    ) {
        return ResponseEntity
                .ok(paymentService.delete(paymentId));
    }

}