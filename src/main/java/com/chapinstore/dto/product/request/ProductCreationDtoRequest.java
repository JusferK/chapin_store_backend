package com.chapinstore.dto.product.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCreationDtoRequest {

    @NotNull(message = "El nombre del producto es requerido.")
    @Size(min = 5, max = 45, message = "El nommbre tiene que ser de 5 a 45 caracteres")
    private String name;

    @NotNull(message = "La descripcion es requerida.")
    @Size(min = 10, max = 150, message = "La descripcion tiene que ser de 10 a 150 caracteres")
    private String description;

    @NotNull(message = "El precio es requerido.")
    private String price;

    @NotNull(message = "La imagen es requerida.")
    private String image;

    @NotNull(message = "El stock es requerido.")
    private Integer stock;

    @NotNull(message = "La categoria es requerida.")
    private String categoryId;

}
