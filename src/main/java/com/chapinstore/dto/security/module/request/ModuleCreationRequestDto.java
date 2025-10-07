package com.chapinstore.dto.security.module.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModuleCreationRequestDto {

    @NotBlank(message = "El nombre del modulo es requerido.")
    @Size(max = 60, message = "El nombre del modulo es requerido.")
    private String name;

    @NotBlank(message = "La ruta base es requerida.")
    @Size(max = 60, message = "La ruta base es de al menos de 60 caracteres")
    private String basePath;

}