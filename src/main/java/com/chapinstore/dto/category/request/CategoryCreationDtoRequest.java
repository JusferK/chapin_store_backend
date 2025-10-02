package com.chapinstore.dto.category.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreationDtoRequest {

    @NotBlank(message = "El nombre de la categoria es requerida.")
    @Size(min = 3, max = 45, message = "El nombre tiene que estar entre 3 a 45 caracteres.")
    private String name;

    @Size(min = 5, max = 300, message = "La descripcion tiene que estar entre 5 a 300 caracteres.")
    private String description;

}
