package com.chapinstore.dto.customer_address.response;

import com.chapinstore.enums.Country;
import com.chapinstore.enums.Department;
import lombok.Data;

@Data
public class CustomerAddressRetrieveDto {

    private String street;
    private String house;
    private Department city;
    private Country country;
    private String neighborhood;

}
