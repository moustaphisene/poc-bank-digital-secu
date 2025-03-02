package com.ebank.bankdigital.repository;

import com.ebank.bankdigital.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {


    List<BankAccount> findByCustomerId(Long customerId);
}
