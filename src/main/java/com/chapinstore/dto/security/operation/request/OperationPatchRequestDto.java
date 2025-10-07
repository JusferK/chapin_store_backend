package com.chapinstore.dto.security.operation.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationPatchRequestDto {

    @NotNull(message = "Id es requerido")
    private Long id;

    @Size(message = "El nombre de la operacion es de hasta 60 caracteres")
    private String name;

    @Size(message = "El nombre del camino es de hasta 60 caracteres")
    private String path;

    @Size(message = "El metodo es de hasta 10 caracteres")
    private String method;

    private Boolean permitAll;

}
