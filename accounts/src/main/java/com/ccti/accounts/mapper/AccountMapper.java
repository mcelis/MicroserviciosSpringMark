package com.ccti.accounts.mapper;

import com.ccti.accounts.dto.AccountDto;
import com.ccti.accounts.entity.Account;

public class AccountMapper {
    public static AccountDto mapAccountToDto(Account account){
        AccountDto accountDto = new AccountDto();

        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setAccountType(accountDto.getAccountType());
        accountDto.setBranchAddress(account.getBranchAddress());

        return accountDto;
    }

    public static Account mapAccoutDtoToAccount(AccountDto accountDto){
        Account account = new Account();

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());

        return  account;
    }

    public static Account mapUpdatingToAccount(AccountDto accountDto, Account account) {

        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());

        return  account;
    }
}
