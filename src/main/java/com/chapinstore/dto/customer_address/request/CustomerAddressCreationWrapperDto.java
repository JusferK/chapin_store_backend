package com.chapinstore.dto.customer_address.request;

import lombok.Data;

@Data
public class CustomerAddressCreationWrapperDto {

    private CustomerAddressCreationDto address;
    private String email;

}