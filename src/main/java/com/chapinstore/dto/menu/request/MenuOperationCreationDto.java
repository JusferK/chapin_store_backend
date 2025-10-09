package com.chapinstore.dto.menu.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuOperationCreationDto {

    @NotBlank(message = "El usuario es requerido")
    private String username;

    @NotBlank(message = "El nombre del menu es requerido")
    @Size(message = "El nombre del menu puede ser de hasta 60 caracteres", max = 60)
    private String label;

    @NotBlank(message = "El icono del menu es requerido")
    @Size(message = "El icono puede ser de hasta 40 caracteres", max = 40)
    private String icon;

    @NotNull(message = "La ruta es requerida")
    @Size(message = "La ruta puede ser de hasta 60 caraceteres", max = 60)
    private String routerLink;

    private Long fatherId;

    @NotNull(message = "Parametro para saber si es padre es requerido")
    private Boolean isFather;

}
