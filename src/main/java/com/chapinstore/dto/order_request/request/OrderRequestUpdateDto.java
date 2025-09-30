package com.chapinstore.dto.order_request.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequestUpdateDto {

    @NotNull(message = "El id de la orden es requerida.")
    private Integer orderRequestId;

    @Size(message = "La direccion tiene que ser entre 30 a 300 caracteres de largo.", min = 30, max = 300)
    private String shippingAddress;

    @NotNull(message = "El id del pago es requerido.")
    private Integer paymentId;

}
