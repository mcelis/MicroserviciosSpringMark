package com.ccti.accounts.dto;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class CustomerAccountDto {
    @Valid
    public CustomerDto customer;

    @Valid
    public AccountDto account;
}
