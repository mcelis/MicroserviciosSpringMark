package com.ccti.accounts.service.impl;

import com.ccti.accounts.dto.CustomerAccountDto;
import com.ccti.accounts.dto.CustomerDto;
import com.ccti.accounts.entity.Account;
import com.ccti.accounts.entity.Customer;
import com.ccti.accounts.exception.CustomerAlreadyExists;
import com.ccti.accounts.exception.ResourceNotFound;
import com.ccti.accounts.mapper.AccountMapper;
import com.ccti.accounts.mapper.CustomerMapper;
import com.ccti.accounts.repository.AccountRepository;
import com.ccti.accounts.repository.CustomerRepository;
import com.ccti.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
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
        account.setCreated_by("System");
        account.setCreated_at(LocalDateTime.now());

        accountRepository.save(account);
    }

    @Override
    public boolean deleteAccount(String email) {
        Customer customer = customerRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFound("cliente", "email", email)
        );
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteByEmail(customer.getEmail());

        return true;
    }


    @Override
    public CustomerAccountDto fetchAccount(String email) {

        Customer customer = customerRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFound("cliente", "email", email)
        );

        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFound("cuenta","customerId", customer.getCustomerId().toString())
        );

        CustomerAccountDto data = new CustomerAccountDto();
        data.setAccount(AccountMapper.mapAccountToDto(account));
        data.setCustomer(CustomerMapper.mapCustomerToDto(customer));
        return data;
    }

    private Customer createCustomer(CustomerDto customerDto){

        Optional<Customer> existingCustomer = customerRepository.findByEmail(customerDto.getEmail());
        if(existingCustomer.isPresent()){
            throw  new CustomerAlreadyExists("El correo electronico" + customerDto.getEmail() + " ya esta registrado");
        }

        Customer customer = CustomerMapper.mapCustomerDtoToCustomer(customerDto);
        customer.setCreated_by("System");
        customer.setCreated_at(LocalDateTime.now());

        return customerRepository.save(customer);
    }
}
