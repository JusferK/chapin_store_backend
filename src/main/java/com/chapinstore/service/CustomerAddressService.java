package com.chapinstore.service;

import com.chapinstore.common.mapper.CustomerAddressMapper;
import com.chapinstore.dto.customer_address.request.CustomerAddressCreationDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import com.chapinstore.entity.CustomerAddress;
import com.chapinstore.enums.Country;
import com.chapinstore.repository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    public List<CustomerAddress> saveAddress(List<CustomerAddressCreationDto> customerAddressCreationDto, String email) {

        List<CustomerAddress> addresses = customerAddressCreationDto
                .stream()
                .map(address -> customerAddressMapper.toCustomerAddress(address))
                .peek(address -> {
                    address.setCustomerEmail(email);
                    address.setCountry(Country.GUATEMALA);
                })
                .toList();


        return customerAddressRepository.saveAll(addresses);
    }

    public CustomerAddressCreationResponseDto createAddress(CustomerAddressCreationDto customerAddressCreationDto, String email) throws IllegalAccessException {
        if (!customerService.isAllowedToAdd(email)) throw new IllegalAccessException("Solo se puede almacenar una direccion a la vez");

        CustomerAddress address =  customerAddressMapper.toCustomerAddress(customerAddressCreationDto);
        address.setCustomerEmail(email);
        address.setCountry(Country.GUATEMALA);

        return customerAddressMapper
                .toCustomerAddressCreationResponseDto(customerAddressRepository.save(address));
    }

}