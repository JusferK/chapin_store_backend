package com.chapinstore.dto.product.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductUpdateDto {

    @NotNull(message = "El id del producto es requerido.")
    private Long productId;

    @Size(min = 5, max = 45, message = "El nommbre tiene que ser de 5 a 45 caracteres")
    private String name;

    @Size(min = 10, max = 150, message = "La descripcion tiene que ser de 10 a 150 caracteres")
    private String description;

    private Double price;

    private Integer stock;

    private String image;

    private String categoryId;

}
