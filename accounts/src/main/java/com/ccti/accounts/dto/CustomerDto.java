package com.ccti.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {
    @NotEmpty(message = "El nombre del cliente es requerido")
    @Size(min = 5, max = 50, message = "EL nombre debe contener entre 5 y 50 caracteres")
    private String name;

    @NotEmpty(message = "El email del cliente es requerido")
    @Email(message = "Debe especificar un email valido")
    private String email;
    @NotEmpty(message = "El numero de celular es requerido")
    @Pattern(regexp = "(^$| [0-9](10}))", message = "El numero de cuenta debe contener 10 digitos")
    private String mobileNumber;
}
