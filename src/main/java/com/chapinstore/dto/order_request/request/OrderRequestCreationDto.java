package com.chapinstore.dto.order_request.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderRequestCreationDto {

    @NotNull(message = "La direccion de entrega es requerida.")
    @Size(message = "La direccion tiene que ser entre 30 a 300 caracteres de largo.", min = 30, max = 300)
    private String shippingAddress;

    @NotNull(message = "El monto total es requerido.")
    private Integer totalAmount;

    @NotNull(message = "El correo del usuario es requerido.")
    private String customerEmail;

    @NotNull(message = "El id del pago es requerido.")
    private Integer paymentId;

}
