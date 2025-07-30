package com.chapinstore.dto.customer.creation;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerEditDto {

    @NotNull(message = "El correo es requerido")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Formato del correo es incorrecto"
    )
    private String email;

    @Size(min = 5, max = 45, message = "La contraseña tiene que ser de 5 a 45 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%,*?&])[A-Za-z\\d@$!%,*?&]{8,}$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial (@$!%*?&,)"
    )
    private String password;

    @Size(min = 5, max = 45, message = "La nombre tiene que ser de 5 a 45 caracteres")
    private String name;

    @Size(min = 5, max = 45, message = "El apellido tiene que ser de 5 a 45 caracteres")
    private String lastName;

    private String profilePhoto;

}
