package com.chapinstore.dto.customer_address.creation;

import lombok.Data;

@Data
public class CustomerAddressCreationWrapperDto {

    private CustomerAddressCreationDto address;
    private String email;

}