package com.chapinstore.dto.security.operation.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OperationCreationWrapperDto {

    @NotNull(message = "El id del modulo es requerido.")
    private Long moduleId;

    @Valid
    @Size(min = 1, message = "Se requiere al menos 1 operacion.")
    private List<OperationCreationDto> operations = new ArrayList<>();

}
