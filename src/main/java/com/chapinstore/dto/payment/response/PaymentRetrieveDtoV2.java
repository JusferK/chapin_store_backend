package com.chapinstore.dto.payment.response;

import lombok.Data;

@Data
public class PaymentRetrieveDtoV2 {

    private String cardHolder;
    private String lastFourDigits;

}
