package com.chapinstore.controller;

import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.dto.customer.creation.CustomerCreationDto;
import com.chapinstore.dto.customer.creation.CustomerEditDto;
import com.chapinstore.dto.customer.response.CustomerCreationResponseDto;
import com.chapinstore.dto.customer.response.CustomerResponseDto;
import com.chapinstore.model.Pagination;
import com.chapinstore.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all")
    public ResponseEntity<Pagination<CustomerResponseDto>> allCustomers(@RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.getAll(page));
    }

    @GetMapping("/get")
    public ResponseEntity<CustomerResponseDto> getCustomer(@RequestParam String email) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.get(email));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse<CustomerCreationResponseDto>> registerCustomer(@Valid @RequestBody CustomerCreationDto request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.register(request));
    }

    @PatchMapping("/patch")
    public ResponseEntity<CustomerEditDto> editCustomer(
            @Valid @RequestBody CustomerEditDto customerEditDto
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.patch(customerEditDto));
    }

    @DeleteMapping("/disable/{email}")
    public ResponseEntity<Map<String, Boolean>> disableCustomer(@PathVariable("email") String email) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerService.disableAccount(email));
    }

}
