package com.chapinstore.dto.customer_address.creation;

import com.chapinstore.enums.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerAddressCreationDto {

    @Size(min = 5, max = 45, message = "La calle debe tener 5 a 45 caracteres")
    @NotBlank(message = "La calle es requerida")
    private String street;

    @Size(min = 5, max = 45, message = "La casa debe tener 5 a 45 caracteres")
    @NotBlank(message = "La casa es requerida")
    private String house;

    @NotNull(message = "La cuidad es requerida")
    private Department city;

    @Size(min = 5, max = 45, message = "La municipalidad debe ser de 5 a 45 caracteres")
    @NotBlank(message = "La municipalidad es requerida.")
    private String neighborhood;

}
