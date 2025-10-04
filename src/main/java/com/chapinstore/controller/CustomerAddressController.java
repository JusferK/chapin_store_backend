package com.chapinstore.controller;

import com.chapinstore.dto.customer_address.request.CustomerAddressCreationWrapperDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressCreationResponseDto;
import com.chapinstore.dto.customer_address.response.CustomerAddressRetrieveDto;
import com.chapinstore.service.CustomerAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @PostMapping("/new")
    public ResponseEntity<CustomerAddressCreationResponseDto> addAddress(
            @Valid @RequestBody CustomerAddressCreationWrapperDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerAddressService.createAddress(
                        request.getAddress(),
                        request.getEmail()
                ));
    }

    @GetMapping("/get")
    public ResponseEntity<List<CustomerAddressRetrieveDto>> get(
            @RequestParam String email
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerAddressService.get(email));
    }



}
