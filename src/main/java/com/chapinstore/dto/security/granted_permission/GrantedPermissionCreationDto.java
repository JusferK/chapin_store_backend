package com.chapinstore.dto.security.granted_permission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GrantedPermissionCreationDto {

    @NotNull(message = "El id del rol es requerido")
    private Long roleId;

    @NotNull(message = "El id de la operacion es requerido.")
    private Long operationId;

}
