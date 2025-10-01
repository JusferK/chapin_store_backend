package com.chapinstore.dto.order_request.request;

import com.chapinstore.dto.detail.request.DetailCreationRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

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

    @Valid
    @Size(min = 1, message = "Se requiere comprar al menos 1 producto.")
    private List<DetailCreationRequestDto> orderDetail;

}
