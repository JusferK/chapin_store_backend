package com.chapinstore.dto.category.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryEditDto {

    @NotNull(message = "El id de la categoria es requerido.")
    private Integer categoryId;

    @Size(min = 5, max = 45, message = "El nombre tiene que estar entre 5 a 45 caracteres.")
    private String name;

    @Size(min = 5, max = 300, message = "La descripcion tiene que estar entre 5 a 300 caracteres.")
    private String description;

}
