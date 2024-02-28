package com.ccti.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Esquema que almacena datos de cuentas"
)
public class AccountDto {

    @Schema(
            description = "Numero de la cuenta en el sistema"
    )
    @NotNull(message = "El numero de cuenta es requerido")
    //@Pattern(regexp = "(^$| [0-9](10}))", message = "El numero de cuenta debe contener 10 digitos")
    private Long accountNumber;

    @Schema(
            description = "Tipo de cuenta en el sistema 'Savings', 'Checking'"
    )
    @NotEmpty(message = "El tipo de cuenta es requerido")
    private String accountType;

    @Schema(
            description = "Direccion sucursal de la cuenta en el sistema"
    )
    @NotEmpty(message = "La direccion es requerida")
    private String branchAddress;
}
