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
    public ResponseEntity<Pagination<ProductRetrieveDtoResponse>> all(
            @RequestParam(required = false, defaultValue = "0") Integer page
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.all(page));
    }

    @GetMapping("/get-all-by-category")
    public ResponseEntity<Pagination<ProductRetrieveDtoResponse>> allByCategory(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam Integer categoryId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.allByCategory(page, categoryId));
    }

    @GetMapping("/get")
    public ResponseEntity<ProductRetrieveDtoResponse> find(
            @RequestParam String argument
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.find(argument));
    }

    @PostMapping("/new")
    public ResponseEntity<ProductCreationDtoResponse> create(
            @Valid @RequestBody ProductCreationDtoRequest productCreationDtoRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.create(productCreationDtoRequest));
    }

    @PatchMapping("/patch")
    public ResponseEntity<ProductUpdateDto> update(
            @Valid @RequestBody ProductUpdateDto productUpdateDtoRequest
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.update(productUpdateDtoRequest));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.delete(id));
    }



}
