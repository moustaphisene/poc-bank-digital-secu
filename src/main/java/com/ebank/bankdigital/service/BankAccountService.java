package com.ebank.bankdigital.service;

import com.ebank.bankdigital.entity.BankAccount;
import com.ebank.bankdigital.entity.Operation;
import com.ebank.bankdigital.entity.AccountStatus;
import com.ebank.bankdigital.entity.OperationType;
import com.ebank.bankdigital.repository.BankAccountRepository;
import com.ebank.bankdigital.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final OperationRepository operationRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository, OperationRepository operationRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.operationRepository = operationRepository;
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        bankAccount.setCreatedAt(LocalDate.now());
        bankAccount.setBalance(BigDecimal.ZERO);
        bankAccount.setStatus(AccountStatus.ACTIVATED);
        return bankAccountRepository.save(bankAccount);
    }

    public Operation createOperation(Operation operation) {
        operation.setOperationDate(LocalDate.now());
        operation.setBankAccount(operation.getBankAccount());
        return operationRepository.save(operation);
    }

    public Operation processOperation(Long accountId, Operation operation) {
        BankAccount bankAccount = operation.getBankAccount();
        if (operation.getType() == OperationType.DEPOSIT) {
            bankAccount.setBalance(bankAccount.getBalance().add(operation.getAmount()));
        } else if (operation.getType() == OperationType.WITHDRAWAL) {
            bankAccount.setBalance(bankAccount.getBalance().subtract(operation.getAmount()));
        }
        bankAccountRepository.save(bankAccount);
        operationRepository.save(operation);
        return operation;
    }
}
