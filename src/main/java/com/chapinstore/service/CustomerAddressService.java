package com.chapinstore.service;

import com.chapinstore.common.mapper.CustomerAddressMapper;
import com.chapinstore.dto.customer_address.request.CustomerAddressCreationDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressRetrieveDto;
import com.chapinstore.entity.CustomerAddress;
import com.chapinstore.enums.Country;
import com.chapinstore.exception.throwable.AddressCreationException;
import com.chapinstore.repository.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    @Autowired
    @Lazy
    private CustomerService customerService;

    public void saveAddress(List<CustomerAddressCreationDto> customerAddressCreationDto, String email) {

        List<CustomerAddress> addresses = customerAddressCreationDto
                .stream()
                .map(address -> customerAddressMapper.toCustomerAddress(address))
                .peek(address -> {
                    address.setCustomerEmail(email);
                    address.setCountry(Country.GUATEMALA);
                })
                .toList();


        customerAddressRepository.saveAll(addresses);
    }

    public CustomerAddressCreationResponseDto createAddress(CustomerAddressCreationDto customerAddressCreationDto, String email) {

        customerService.find(email);

        if (!isAllowedToAdd(email)) throw new AddressCreationException("Solo se puede almacenar una direccion a la vez");

        CustomerAddress address =  customerAddressMapper.toCustomerAddress(customerAddressCreationDto);
        address.setCustomerEmail(email);
        address.setCountry(Country.GUATEMALA);

        return customerAddressMapper
                .toCustomerAddressCreationResponseDto(customerAddressRepository.save(address));
    }

    public List<CustomerAddressRetrieveDto> get(String email) {
        List<CustomerAddress> findAddresses = customerAddressRepository.findByCustomerEmail(email);

        return findAddresses
                .stream()
                .map(address -> customerAddressMapper.toCustomerAddressRetrieveDto(address))
                .toList();
    }

    /*
     *
     * COMO RECORDATORIO, EN MIS REGLAS DE NEGOCIO,
     * EL USUARIO SOLO PUEDE UNA DIRECCION.
     *
     */
    public Boolean isAllowedToAdd(String email) {
        return customerAddressRepository
                .findByCustomerEmail(email)
                .isEmpty();
    }

}