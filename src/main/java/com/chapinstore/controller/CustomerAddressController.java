package com.chapinstore.controller;

import com.chapinstore.dto.customer_address.creation.CustomerAddressCreationWrapperDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import com.chapinstore.service.CustomerAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/add-address")
    public ResponseEntity<CustomerAddressCreationResponseDto> addAddress(
            @Valid @RequestBody CustomerAddressCreationWrapperDto customerAddressCreationWrapperDto
    ) throws IllegalAccessException {
        return ResponseEntity
                .ok()
                .body(customerAddressService.createAddress(customerAddressCreationWrapperDto.getAddress(), customerAddressCreationWrapperDto.getEmail()));
    }

}
