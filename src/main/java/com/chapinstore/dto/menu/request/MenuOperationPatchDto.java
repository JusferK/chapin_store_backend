package com.chapinstore.dto.menu.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuOperationPatchDto {

    @NotNull
    private Long id;

    @Size(message = "El nombre del menu puede ser de hasta 60 caracteres", max = 60)
    private String label;

    @Size(message = "El icono puede ser de hasta 40 caracteres", max = 40)
    private String icon;

    @Size(message = "La ruta puede ser de hasta 60 caraceteres", max = 60)
    private String routerLink;

    private Boolean isFather;

}
