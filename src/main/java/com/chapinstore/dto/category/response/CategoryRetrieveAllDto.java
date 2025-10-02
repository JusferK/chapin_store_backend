package com.chapinstore.dto.category.response;

import lombok.Data;

@Data
public class CategoryRetrieveAllDto {

    private Integer categoryId;
    private String name;
    private String description;

}
