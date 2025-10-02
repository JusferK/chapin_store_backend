package com.chapinstore.dto.order_request.response;

import com.chapinstore.dto.detail.response.DetailRetrieveDto;
import com.chapinstore.dto.payment.response.PaymentRetrieveDtoV2;
import com.chapinstore.enums.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderRequestRetrieveDto {

    private Integer orderRequestId;
    private String shippingAddress;
    private Integer totalAmount;
    private Status status;
    private Date estimatedDeliveryDate;
    private Date orderDate;
    private PaymentRetrieveDtoV2 paymentInfo;
    private List<DetailRetrieveDto> orderDetail;

}
