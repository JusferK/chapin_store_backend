package com.chapinstore.dto.security.role.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateRoleRequest {

    @NotBlank(message = "El nombre del rol es requerido.")
    @Size(message = "El nombre tiene como maximo 30 caracteres", max = 30)
    private String name;


}
