package com.chapinstore.dto.customer.response;

import com.chapinstore.dto.customer_address.request.CustomerAddressCreationDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerCreationResponseDto {

    private String email;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private Date creationDate;
    private List<CustomerAddressCreationDto> addresses;

}
