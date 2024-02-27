package com.ccti.accounts.service;

import com.ccti.accounts.dto.CustomerAccountDto;
import com.ccti.accounts.dto.CustomerDto;

public interface IAccountService {

    boolean updateAccount(CustomerAccountDto data);
    void createAccount(CustomerDto customerDto);

    boolean deleteAccount(String email);

    CustomerAccountDto fetchAccount(String email);
}
