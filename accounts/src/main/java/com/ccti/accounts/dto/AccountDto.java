package com.ccti.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

    @NotEmpty(message = "El numero de cuenta es requerido")
    @Pattern(regexp = "(^$| [0-9](10}))", message = "El numero de cuenta debe contener 10 digitos")
    private Long accountNumber;
    @NotEmpty(message = "El tipo de cuenta es requerido")
    private String accountType;
    @NotEmpty(message = "La direccion es requerida")
    private String branchAddress;
}
