package com.chapinstore.dto.security.module.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModulePatchRequestDto {

    @NotBlank(message = "El id es requerido")
    private Long id;

    @Size(max = 60, message = "El nombre es de hasta 60 caracteres")
    private String name;

    @Size(message = "La ruta base es de hasta 60 caracteres")
    private String basePath;

    private Boolean active;

}
