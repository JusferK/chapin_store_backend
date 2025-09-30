package com.chapinstore.controller;

import com.chapinstore.dto.product.request.ProductCreationDtoRequest;
import com.chapinstore.dto.product.request.ProductUpdateDto;
import com.chapinstore.dto.product.response.ProductCreationDtoResponse;
import com.chapinstore.dto.product.response.ProductRetrieveDtoResponse;
import com.chapinstore.model.Pagination;
import com.chapinstore.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get-all")
    private ResponseEntity<Pagination<ProductRetrieveDtoResponse>> all(
            @RequestParam(required = false, defaultValue = "0") Integer page
    ) {
        return ResponseEntity.ok(productService.all(page));
    }

    @GetMapping("/get")
    private ResponseEntity<ProductRetrieveDtoResponse> find(
            @RequestParam String argument
    ) {
        return ResponseEntity.ok(productService.find(argument));
    }

    @PostMapping("/new")
    private ResponseEntity<ProductCreationDtoResponse> create(
            @Valid @RequestBody ProductCreationDtoRequest productCreationDtoRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.create(productCreationDtoRequest));
    }

    @PatchMapping("/patch")
    private ResponseEntity<ProductUpdateDto> update(
            @Valid @RequestBody ProductUpdateDto productUpdateDtoRequest
    ) {
        return ResponseEntity.ok(productService.update(productUpdateDtoRequest));
    }

    @DeleteMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity
                .ok(productService.delete(id));
    }



}
