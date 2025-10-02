package com.chapinstore.dto.detail.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetailCreationRequestDto {

    @NotNull(message = "El subtotal es requrido.")
    private Double subtotal;

    @NotNull(message = "La cantidad es requerida.")
    private Integer quantity;

    @NotNull(message = "El id del producto es requerido.")
    private Long productId;

}