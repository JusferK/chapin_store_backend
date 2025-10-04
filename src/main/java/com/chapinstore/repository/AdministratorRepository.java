package com.chapinstore.repository;

import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    public Optional<Administrator> findByUsername(String username);
}