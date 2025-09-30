package com.chapinstore.dto.customer.creation;

import com.chapinstore.dto.customer_address.request.CustomerAddressCreationDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CustomerCreationDto {

    @NotNull(message = "El correo es requerido")
    @Size(min = 5, max = 45, message = "El correo debe de estar entre 10 y 45 caracteres")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Formato del correo es incorrecto"
    )
    private String email;

    @NotNull(message = "La contraseña es requerida")
    @Size(min = 5, max = 45, message = "La contraseña tiene que ser de 5 a 45 caracteres")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%,*?&])[A-Za-z\\d@$!%,*?&]{8,}$",
            message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial (@$!%*?&,)"
    )
    private String password;

    @NotNull(message = "El nombre es requerido")
    @Size(min = 5, max = 45, message = "La nombre tiene que ser de 5 a 45 caracteres")
    private String name;

    @NotNull(message = "El apellido es requerido")
    @Size(min = 5, max = 45, message = "El apellido tiene que ser de 5 a 45 caracteres")
    private String lastName;

    @NotNull(message = "La fecha de nacimiento es requerida")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private Date dateOfBirth;

    private String profilePhoto;

    @Valid
    @Size(max = 1, message = "Solo una direccion puede ser agregada")
    private List<CustomerAddressCreationDto> addresses;

}