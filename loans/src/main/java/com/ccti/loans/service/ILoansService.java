package com.ccti.loans.service;

import com.ccti.loans.dto.LoansDto;

public interface ILoansService {

    void createLoan(String email);

    LoansDto fetchLoan(String email);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String email);

}
