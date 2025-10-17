package com.chapinstore.repository;

import com.chapinstore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> findByName(String name);
    public Optional<Product> findByDescription(String description);
    public Page<Product> findByCategoryId(Integer categoryId, Pageable pageable);

    @Query("""
    SELECT p FROM Product p
    WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
       OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))
    ORDER BY CASE 
        WHEN LOWER(p.name) LIKE LOWER(CONCAT(:keyword, '%')) THEN 1
        WHEN LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) THEN 2
        ELSE 3
    END
        """)
    public List<Product> search(@Param("keyword") String keyword);

}