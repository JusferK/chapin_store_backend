package com.chapinstore.controller;

import com.chapinstore.dto.category.request.CategoryCreationDtoRequest;
import com.chapinstore.dto.category.request.CategoryEditDto;
import com.chapinstore.dto.category.response.CategoryCreationResponseDto;
import com.chapinstore.dto.category.response.CategoryRetrieveAllDto;
import com.chapinstore.model.Pagination;
import com.chapinstore.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get-all")
    public ResponseEntity<Pagination<CategoryRetrieveAllDto>> getAllCategories(
            @RequestParam(required = false, defaultValue = "0") Integer page
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.all(page));
    }

    @PostMapping("/new")
    public ResponseEntity<CategoryCreationResponseDto> save(
            @Valid @RequestBody CategoryCreationDtoRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @PatchMapping("/patch")
    public ResponseEntity<CategoryEditDto> patchCategory(
            @Valid @RequestBody CategoryEditDto request
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.edit(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Boolean>> delete(
            @RequestParam(required = false, defaultValue = "0") Integer id
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryService.delete(id));
    }

}