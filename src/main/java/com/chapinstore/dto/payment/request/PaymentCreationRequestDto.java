package com.chapinstore.dto.payment.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentCreationRequestDto {

    @NotNull(message = "El nombre del dueño es requerido.")
    @Size(message = "El nombre debe de estar de 5 a 45 caracteres", max = 45, min = 5)
    private String cardHolder;

    @NotNull(message = "El codigo de la tarjeta es requerido.")
    @Size(min = 3, max = 3, message = "El codigo es de 3 digitos")
    @Pattern(regexp = "^\\d{3}$", message = "El CVV debe tener exactamente 3 dígitos")
    private String cvv;

    @NotNull(message = "La numeracion de la tarjeta es requerida.")
    @Size(min = 16, max = 16, message = "La numeracion de la tarjeta deben ser 16 digitos")
    private String cardNumber;

    @NotNull(message = "La fecha de expiracion es requerida.")
    @Future(message = "La fecha de expiracion debe ser una futura.")
    private Date expirationDate;

    @NotNull(message = "El correo es requerido.")
    private String customerEmail;

}
