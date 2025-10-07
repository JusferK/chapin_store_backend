package com.chapinstore.dto.security.operation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationCreationDto {


    @NotBlank(message = "Se requiere el nombre de la operacion")
    @Size(max = 60, message = "El nombre es de hasta 60 caracteres")
    private String name;

    @NotBlank(message = "Se requiere la ruta de la operacion")
    @Size(max = 40, message = "La ruta es de almenos 40 caracteres")
    private String path;

    @NotBlank(message = "El metodo es requerido")
    @Size(max = 10, message = "El metodo es de al menos 10 caracteres")
    private String method;

    @NotNull(message = "El campo permitir por todos es requerido.")
    private Boolean permitAll;

}