package com.chapinstore.common.mapper;

import com.chapinstore.dto.customer_address.request.CustomerAddressCreationDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import com.chapinstore.entity.CustomerAddress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerAddressMapper {

    CustomerAddress toCustomerAddress(CustomerAddressCreationDto customerAddressCreationDto);

    CustomerAddressCreationResponseDto toCustomerAddressCreationResponseDto(CustomerAddress customerAddress);

}
