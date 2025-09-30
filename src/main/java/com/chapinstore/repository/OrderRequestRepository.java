package com.chapinstore.repository;

import com.chapinstore.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRequestRepository extends JpaRepository<OrderRequest, Integer> {

    public List<OrderRequest> findByCustomerEmail(String customerEmail);
    public List<OrderRequest> findByEstimatedDeliveryDate(Date estimatedDeliveryDate);

}
