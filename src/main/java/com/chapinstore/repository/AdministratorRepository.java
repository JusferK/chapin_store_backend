package com.chapinstore.repository;

import com.chapinstore.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<OrderRequest, String> {}