package com.chapinstore.service;

import com.chapinstore.common.mapper.ProductMapper;
import com.chapinstore.dto.product.request.ProductCreationDtoRequest;
import com.chapinstore.dto.product.request.ProductUpdateDto;
import com.chapinstore.dto.product.response.ProductCreationDtoResponse;
import com.chapinstore.dto.product.response.ProductRetrieveDtoResponse;
import com.chapinstore.entity.Product;
import com.chapinstore.model.Pagination;
import com.chapinstore.repository.ProductRepository;
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
import java.util.Optional;

@Service
public class ProductService {

    @Value("${application.product.property}")
    private String property;

    @Value("${application.product.page-size}")
    private Integer pageSize;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public Pagination<ProductRetrieveDtoResponse> all(Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.ASC, property);
        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductRetrieveDtoResponse> content = productPage
                .getContent()
                .stream()
                .map(product -> productMapper.toProductRetrieveDtoResponse(product))
                .toList();

        return Pagination.<ProductRetrieveDtoResponse>
                builder()
                .content(content)
                .page(page)
                .totalElements((int) productPage.getTotalElements())
                .size(content.size())
                .totalPages(productPage.getTotalPages())
                .build();

    }

    public ProductRetrieveDtoResponse find(String argument) {
        Product findProduct = findProduct(argument);
        return productMapper.toProductRetrieveDtoResponse(findProduct);
    }

    public ProductCreationDtoResponse create(ProductCreationDtoRequest productCreationDtoRequest) {

        Optional<Product> findByName = productRepository.findByName(productCreationDtoRequest.getName());
        if (findByName.isPresent()) throw new IllegalArgumentException("Producto con este nombre ya existe");

        Product product = productMapper.toProduct(productCreationDtoRequest);
        product = productRepository.save(product);

        return productMapper.toProductCreationDtoResponse(product);
    }

    public ProductUpdateDto update(ProductUpdateDto productUpdateDtoRequest) {
        Product findProduct = productRepository.findById(productUpdateDtoRequest.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("El producto no fue encontrado."));

        mapAndUpdate(findProduct, productUpdateDtoRequest);

        return productUpdateDtoRequest;
    }

    public Map<String, Boolean> delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("El producto no fue encontrado.")
        );

        productRepository.delete(product);
        return Map.of("deleted", Boolean.TRUE);
    }


    private Product findProduct(String id) {
        Product findById = findById(id);
        Product findByString = findByString(id);

        if (findById != null) return findById;
        else if (findByString != null) return findByString;

        throw new EntityNotFoundException("El producto no fue encontrado.");
    }

    private Product findById(String id) {
        try {
            Long productId = Long.parseLong(id);
            Optional<Product> findProduct = productRepository.findById(productId);
            if (findProduct.isPresent()) return findProduct.get();
        } catch (Exception exception) {
            System.out.println(exception.getCause().getMessage());
        }
        return null;
    }

    private Product findByString(String argument) {

        Optional<Product> findByName = productRepository.findByName(argument);
        Optional<Product> findByDescription = productRepository.findByDescription(argument);

        if (findByName.isPresent()) return findByName.get();
        else if (findByDescription.isPresent()) return findByDescription.get();

        return null;
    }

    private void mapAndUpdate(
            Product product,
            ProductUpdateDto productDto
    ) {
        if (productDto.getName() != null) product.setName(productDto.getName());
        if (productDto.getDescription() != null) product.setDescription(productDto.getDescription());
        if (productDto.getPrice() != null) product.setPrice(productDto.getPrice());
        if (productDto.getStock() != null) product.setStock(productDto.getStock());
        if (productDto.getImage() != null) product.setImage(productDto.getImage());
        if (productDto.getCategoryId() != null) product.setCategoryId(productDto.getCategoryId());

        productRepository.save(product);
    }



}