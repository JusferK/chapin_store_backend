package com.chapinstore.repository;

import com.chapinstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByName(String name);
    public Optional<Product> findByDescription(String description);
    public Page<Product> findByCategoryId(Integer categoryId, Pageable pageable);

}