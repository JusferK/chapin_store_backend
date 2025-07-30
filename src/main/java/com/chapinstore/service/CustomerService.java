package com.chapinstore.service;

import com.chapinstore.common.mapper.CustomerMapper;
import com.chapinstore.dto.customer.creation.CustomerCreationDto;
import com.chapinstore.dto.customer.creation.CustomerEditDto;
import com.chapinstore.dto.customer.response.CustomerCreationResponseDto;
import com.chapinstore.dto.customer.response.CustomerListResponseDto;
import com.chapinstore.entity.Customer;
import com.chapinstore.enums.Role;
import com.chapinstore.model.Pagination;
import com.chapinstore.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {

    @Value("${application.user.page-size}")
    private Integer pageSize;

    @Value("${application.user.property}")
    private String property;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAddressService customerAddressService;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerCreationResponseDto registerCustomer(CustomerCreationDto customerCreationDto) {

        Customer customer = customerMapper.toCustomer(customerCreationDto);
        validatePassword(customer);

        customer.setRole(Role.CUSTOMER);
        Customer savedCustomer = customerRepository.save(customer);
        if (!customerCreationDto.getAddresses().isEmpty())
            savedCustomer.setAddresses(
                    customerAddressService.saveAddress(customerCreationDto.getAddresses(), savedCustomer.getEmail())
            );


        return customerMapper
                .toCustomerCreationResponseDto(savedCustomer);
    }

    public Pagination<CustomerListResponseDto> getAllCustomers(Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.ASC, property);
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        List<CustomerListResponseDto> content = customerPage.getContent()
                .stream()
                .map(customer -> customerMapper.toCustomerListResponseDto(customer))
                .toList();

        return Pagination.<CustomerListResponseDto>
                builder()
                .content(content)
                .page(page)
                .totalElements((int) customerPage.getTotalElements())
                .size(content.size())
                .totalPages(customerPage.getTotalPages())
                .build();

    }

    public CustomerEditDto patchCustomer(CustomerEditDto customerEditDto) {
        Customer findCustomer = customerRepository.findByEmail(customerEditDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));

        patchCustomer(findCustomer, customerEditDto);

        return customerEditDto;
    }

    public Map<String, Boolean> disableAccount(String email) {
        Customer findCustomer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));

        customerRepository.delete(findCustomer);

        return Map.of("removed", true);
    }

    public Boolean isAllowedToAdd(String email) {
        Customer findCustomer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));

        return findCustomer.getAddresses().isEmpty();

    }

    private void patchCustomer(Customer customer, CustomerEditDto customerEditDto) {
        if (customerEditDto.getName() != null) customer.setName(customerEditDto.getName());
        if (customerEditDto.getPassword() != null) customer.setPassword(customerEditDto.getPassword());
        if (customerEditDto.getLastName() != null) customer.setLastName(customerEditDto.getLastName());
        if (customerEditDto.getProfilePhoto() != null) customer.setProfilePhoto(customerEditDto.getProfilePhoto());

        customerRepository.save(customer);
    }

    private void validatePassword(Customer customer) {}

}
