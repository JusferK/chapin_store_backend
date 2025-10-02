package com.chapinstore.repository;

import com.chapinstore.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

    public List<CustomerAddress> findByCustomerEmail(String customerEmail);

}