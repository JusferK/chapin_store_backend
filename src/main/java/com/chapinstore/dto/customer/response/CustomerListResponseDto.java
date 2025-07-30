package com.chapinstore.dto.customer.response;

import com.chapinstore.dto.customer_address.response.CustomerAddressRetrieveDto;
import com.chapinstore.dto.order_request.response.OrderRequestRetrieveDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CustomerListResponseDto {

    private String email;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private String profilePhoto;
    private List<CustomerAddressRetrieveDto> addresses = new ArrayList<>();
    private List<OrderRequestRetrieveDto> ordersRequest = new ArrayList<>();

}
