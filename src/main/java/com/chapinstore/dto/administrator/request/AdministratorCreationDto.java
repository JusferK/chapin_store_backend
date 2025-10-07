package com.chapinstore.dto.administrator.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdministratorCreationDto {

    @NotNull(message = "El usuario es requerido.")
    @Size(max = 50, message = "El usuario debe de ser de 50 caracteres")
    private String username;

    @NotNull(message = "La contraseña es requerida")
    @Size(min = 8, max = 45, message = "La contraseña esta entre 8 a 45 caracteres")
    private String password;

    @NotNull(message = "El tipo de usuario es requerido")
    private String role;

}
