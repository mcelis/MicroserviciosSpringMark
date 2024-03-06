package com.ccti.loans.repository;

import com.ccti.loans.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findByEmail(String email);

    Optional<Loans> findByLoanNumber(String loanNumber);

}
