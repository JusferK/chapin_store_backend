package com.chapinstore.dto.payment.response;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentRetrieveDto {

    private Integer paymentId;
    private String cardHolder;
    private String lastFourDigits;
    private Date expirationDate;

}
