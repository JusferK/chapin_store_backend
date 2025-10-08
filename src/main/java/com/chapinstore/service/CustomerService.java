package com.chapinstore.service;

import com.chapinstore.common.mapper.CustomerMapper;
import com.chapinstore.dto.authentication.response.AuthenticationResponse;
import com.chapinstore.dto.customer.creation.CustomerCreationDto;
import com.chapinstore.dto.customer.creation.CustomerEditDto;
import com.chapinstore.dto.customer.response.CustomerCreationResponseDto;
import com.chapinstore.dto.customer.response.CustomerResponseDto;
import com.chapinstore.entity.Customer;
import com.chapinstore.model.Pagination;
import com.chapinstore.repository.CustomerRepository;
import com.chapinstore.service.security.JwtService;
import com.chapinstore.service.security.RoleService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private JwtService jwtService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticationResponse<CustomerCreationResponseDto> register(CustomerCreationDto request) {

        customerRepository.findByEmail(request.getEmail())
                .ifPresent(entity -> {
                    throw new EntityExistsException("Este correo ya esta registrado.");
                });

        Customer customer = customerMapper.toCustomer(request);

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(roleService.CustomerRole("CUSTOMER"));

        Customer savedCustomer = customerRepository.save(customer);
        if (!request.getAddresses().isEmpty())
            customerAddressService.saveAddress(request.getAddresses(), savedCustomer.getEmail());

        String jwt = jwtService.generate(savedCustomer, generateClaims(savedCustomer));

        CustomerCreationResponseDto dto = customerMapper.toCustomerCreationResponseDto(savedCustomer);
        dto.setAddresses(request.getAddresses());

        return new AuthenticationResponse<>(jwt, dto);
    }

    public Pagination<CustomerResponseDto> getAll(Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.ASC, property);
        Page<Customer> customerPage = customerRepository.findAll(pageable);

        List<CustomerResponseDto> content = customerPage.getContent()
                .stream()
                .map(customer -> customerMapper.toCustomerResponseDto(customer))
                .toList();

        return Pagination.<CustomerResponseDto>
                builder()
                .content(content)
                .page(page)
                .totalElements((int) customerPage.getTotalElements())
                .size(content.size())
                .totalPages(customerPage.getTotalPages())
                .build();

    }

    public CustomerResponseDto get(String email) {
        Customer find = customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("El usuario no fue encontrado."));


        return customerMapper
                .toCustomerResponseDto(find);
    }

    public CustomerEditDto patch(CustomerEditDto customerEditDto) {
        Customer findCustomer = customerRepository.findByEmail(customerEditDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));

        patch(findCustomer, customerEditDto);

        return customerEditDto;
    }

    public Map<String, Boolean> disableAccount(String email) {
        Customer findCustomer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));

        customerRepository.delete(findCustomer);

        return Map.of("removed", true);
    }

    public Customer find(String email) {
        return customerRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no fue encontrado."));
    }

    public Customer findNullable(String email) {
        return customerRepository
                .findByEmail(email)
                .orElse(null);
    }

    private void patch(Customer customer, CustomerEditDto customerEditDto) {
        if (customerEditDto.getName() != null) customer.setName(customerEditDto.getName());
        if (customerEditDto.getPassword() != null) customer.setPassword(customerEditDto.getPassword());
        if (customerEditDto.getLastName() != null) customer.setLastName(customerEditDto.getLastName());
        if (customerEditDto.getProfilePhoto() != null) customer.setProfilePhoto(customerEditDto.getProfilePhoto());

        customerRepository.save(customer);
    }

    private Map<String, Object> generateClaims(Customer customer) {
        return Map.of(
                "name", customer.getName() + " " + customer.getLastName(),
                "role", customer.getRole().getName(),
                "authorities", customer.getAuthorities()
        );
    }

}
