package com.ccti.accounts.service;

import com.ccti.accounts.dto.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDto);
}
