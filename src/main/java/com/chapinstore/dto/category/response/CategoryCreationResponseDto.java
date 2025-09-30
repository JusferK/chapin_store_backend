package com.chapinstore.dto.category.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryCreationResponseDto {

    private Long categoryId;
    private String name;
    private String description;

}
