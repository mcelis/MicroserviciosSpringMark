package com.ccti.loans.service.impl;

import com.ccti.loans.constants.LoansConstants;
import com.ccti.loans.dto.LoansDto;
import com.ccti.loans.entity.Loans;
import com.ccti.loans.exception.LoanAlreadyExistsException;
import com.ccti.loans.exception.ResourceNotFoundException;
import com.ccti.loans.mapper.LoansMapper;
import com.ccti.loans.repository.LoansRepository;
import com.ccti.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {

    private LoansRepository loansRepository;

    @Override
    public void createLoan(String email) {
        Optional<Loans> optionalLoans= loansRepository.findByEmail(email);
        if(optionalLoans.isPresent()){
            throw new LoanAlreadyExistsException("Loan already registered with given email "+email);
        }
        loansRepository.save(createNewLoan(email));
    }

    private Loans createNewLoan(String email) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setEmail(email);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoansDto fetchLoan(String email) {
        Loans loans = loansRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "email", email)
        );
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);
        return  true;
    }

    @Override
    public boolean deleteLoan(String email) {
        Loans loans = loansRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "email", email)
        );
        loansRepository.deleteById(loans.getLoanId());
        return true;
    }


}
