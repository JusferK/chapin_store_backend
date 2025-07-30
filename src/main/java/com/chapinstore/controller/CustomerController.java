package com.chapinstore.controller;

import com.chapinstore.dto.customer.creation.CustomerCreationDto;
import com.chapinstore.dto.customer.creation.CustomerEditDto;
import com.chapinstore.dto.customer.response.CustomerCreationResponseDto;
import com.chapinstore.dto.customer.response.CustomerListResponseDto;
import com.chapinstore.model.Pagination;
import com.chapinstore.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-customer")
    public ResponseEntity<Pagination<CustomerListResponseDto>> allCustomers(@RequestParam(required = false, defaultValue = "0") Integer page) {
        return ResponseEntity
                .ok()
                .body(customerService.getAllCustomers(page));
    }

    @PostMapping("/register-customer")
    public ResponseEntity<CustomerCreationResponseDto> registerCustomer(@Valid @RequestBody CustomerCreationDto customerCreationDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.registerCustomer(customerCreationDto));
    }

    @PatchMapping("/edit-customer")
    public ResponseEntity<CustomerEditDto> editCustomer(@Valid @RequestBody CustomerEditDto customerEditDto) {
        return ResponseEntity
                .ok()
                .body(customerService.patchCustomer(customerEditDto));
    }

    @DeleteMapping("/disable-customer/{email}")
    public ResponseEntity<Map<String, Boolean>> disableCustomer(@PathVariable("email") String email) {
        return ResponseEntity
                .ok()
                .body(customerService.disableAccount(email));
    }

}
