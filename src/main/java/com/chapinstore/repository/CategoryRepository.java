package com.chapinstore.repository;

import com.chapinstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Optional<Category> findByName(String name);
}