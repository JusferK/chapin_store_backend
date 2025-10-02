package com.chapinstore.service;

import com.chapinstore.common.mapper.CategoryMapper;
import com.chapinstore.dto.category.request.CategoryCreationDtoRequest;
import com.chapinstore.dto.category.request.CategoryEditDto;
import com.chapinstore.dto.category.response.CategoryCreationResponseDto;
import com.chapinstore.dto.category.response.CategoryRetrieveAllDto;
import com.chapinstore.entity.Category;
import com.chapinstore.model.Pagination;
import com.chapinstore.repository.CategoryRepository;
import jakarta.persistence.EntityExistsException;
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
public class CategoryService {

    @Value("${application.category.page-size}")
    private int pageSize;

    @Value("${application.category.property}")
    private String property;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Pagination<CategoryRetrieveAllDto> all(Integer page) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.ASC, property);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        List<CategoryRetrieveAllDto> content = categoryPage.getContent()
                .stream()
                .map(categoryMapper::toCategoryRetrieveAllDto)
                .toList();

        return Pagination.<CategoryRetrieveAllDto>
                builder()
                .content(content)
                .page(page)
                .totalElements((int) categoryPage.getTotalElements())
                .size(categoryPage.getSize())
                .totalPages(categoryPage.getTotalPages())
                .build();

    }

    public CategoryCreationResponseDto save(CategoryCreationDtoRequest request) {

        categoryRepository.findByName(request.getName())
                .ifPresent(category -> {
                    throw new EntityExistsException("Esta categoria ya existe.");
                });

        Category newCategory = categoryMapper.toCategoryCreationDtoRequest(request);
        newCategory = categoryRepository.save(newCategory);
        return categoryMapper.toCategoryCreationResponseDto(newCategory);
    }

    public CategoryEditDto edit(CategoryEditDto request) {

        Category findCategory = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("La categoria no fue encontrada."));

        updateAndSave(findCategory, request);

        return request;
    }

    public Map<String, Boolean> delete(Integer id) {

        Optional<Category> findCategory = categoryRepository.findById(id);
        if (findCategory.isEmpty()) return Map.of("deleted", false);
        categoryRepository.deleteById(id);

        return Map.of("deleted", true);
    }

    public void findById(Integer id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La categoria no encontrada."));
    }

    private void updateAndSave(Category category, CategoryEditDto categoryDto) {
        if (categoryDto.getName() != null) category.setName(categoryDto.getName());
        if (categoryDto.getDescription() != null) category.setDescription(categoryDto.getDescription());

        categoryRepository.save(category);
    }

}
