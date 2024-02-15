package com.ccti.accounts.service.impl;

import com.ccti.accounts.dto.CustomerDto;
import com.ccti.accounts.entity.Account;
import com.ccti.accounts.entity.Customer;
import com.ccti.accounts.mapper.CustomerMapper;
import com.ccti.accounts.repository.AccountRepository;
import com.ccti.accounts.repository.CustomerRepository;
import com.ccti.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = createCustomer(customerDto);

        long accNumber = 10000000000L + new Random().nextInt(900000000);

        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        account.setAccountType("saving");
        account.setAccountNumber(accNumber);
        account.setBranchAddress("Principal");

        accountRepository.save(account);
    }

    private Customer createCustomer(CustomerDto customerDto){
        Customer customer = CustomerMapper.mapCustomerDtoToCustomer(customerDto);
        customer.setCreated_by("System");
        customer.setCreated_at(LocalDateTime.now());

        return customerRepository.save(customer);
    }
}