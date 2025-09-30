package com.chapinstore.common.mapper;

import com.chapinstore.dto.order_request.response.PaymentRetrieveDto;
import com.chapinstore.dto.payment.request.PaymentCreationRequestDto;
import com.chapinstore.dto.payment.response.PaymentCreationResponseDto;
import com.chapinstore.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    Payment toPayment(PaymentCreationRequestDto paymentCreationRequestDto);
    PaymentCreationResponseDto toPaymentCreationResponseDto(Payment payment);
    PaymentRetrieveDto toPaymentRetrieveDto(Payment payment);

}
