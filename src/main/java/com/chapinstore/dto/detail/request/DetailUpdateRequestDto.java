package com.chapinstore.dto.detail.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetailUpdateRequestDto {

    @NotNull(message = "El id del detalle es requerido.")
    private Integer orderDetailId;

    @NotNull(message = "La nueva cantidad es requerida.")
    private Integer quantity;

}
