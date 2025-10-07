package com.chapinstore.dto.authentication.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "El usuario es requerido.")
    private String username;

    @NotBlank(message = "La contraseña es requerida")
    private String password;

}
