package com.chapinstore.dto.order_request.response;

import com.chapinstore.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class OrderRequestRetrieveDto {

    private Integer orderRequestId;
    private String shippingAddress;
    private Integer totalAmount;
    private Status status;
    private Date estimatedDeliveryDate;
    private Date orderDate;

}
