package com.chapinstore.common.mapper;

import com.chapinstore.dto.customer.creation.CustomerCreationDto;
import com.chapinstore.dto.customer.response.CustomerCreationResponseDto;
import com.chapinstore.dto.customer.response.CustomerResponseDto;
import com.chapinstore.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerCreationDto customerEditDto);
    CustomerCreationResponseDto toCustomerCreationResponseDto(Customer customer);
    CustomerResponseDto toCustomerResponseDto(Customer customer);

}
