package com.chapinstore.dto.security.granted_permission;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

@Getter
public class GrantedPermissionWrapperDto {

    @Valid
    @Size(min = 1)
    List<GrantedPermissionCreationDto> permissions;

}
