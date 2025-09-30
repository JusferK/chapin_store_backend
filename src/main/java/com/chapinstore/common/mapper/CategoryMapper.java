package com.chapinstore.common.mapper;

import com.chapinstore.dto.category.request.CategoryCreationDtoRequest;
import com.chapinstore.dto.category.response.CategoryCreationResponseDto;
import com.chapinstore.dto.category.response.CategoryRetrieveAllDto;
import com.chapinstore.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryRetrieveAllDto toCategoryRetrieveAllDto(Category category);
    Category toCategoryCreationDtoRequest(CategoryCreationDtoRequest request);
    CategoryCreationResponseDto toCategoryCreationResponseDto(Category category);

}