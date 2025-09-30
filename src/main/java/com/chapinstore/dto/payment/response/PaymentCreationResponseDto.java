package com.chapinstore.dto.payment.response;

import lombok.Data;

@Data
public class PaymentCreationResponseDto {

    private Integer paymentId;
    private String cardHolder;
    private String lastFourDigits;

}
