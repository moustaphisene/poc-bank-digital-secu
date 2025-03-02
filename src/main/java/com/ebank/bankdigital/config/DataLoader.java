package com.ebank.bankdigital.config;

import com.ebank.bankdigital.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ebank.bankdigital.repository.BankAccountRepository;
import com.ebank.bankdigital.repository.CustomerRepository;
import com.ebank.bankdigital.repository.OperationRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, OperationRepository operationRepository) {
        return args -> {
            // Insérer des clients
            Customer john = new Customer("John Doe", "john.doe@example.com", "1234567890");
            Customer jane = new Customer("Jane Smith", "jane.smith@example.com", "0987654321");
            customerRepository.save(john);
            customerRepository.save(jane);

            // Insérer des comptes bancaires
            BankAccount account1 = new BankAccount();
            account1.setCustomer(john);
            account1.setCreatedAt(LocalDate.now());
            account1.setBalance(new BigDecimal("1000.00"));
            account1.setStatus(AccountStatus.valueOf("ACTIVATED"));
            account1.setCurrency("USD");
            bankAccountRepository.save(account1);

            BankAccount account2 = new BankAccount();
            account2.setCustomer(jane);
            account2.setCreatedAt(LocalDate.now());
            account2.setBalance(new BigDecimal("500.00"));
            account2.setStatus(AccountStatus.valueOf("ACTIVATED"));
            account2.setCurrency("EUR");
            bankAccountRepository.save(account2);

            // Insérer des opérations
            Operation operation1 = new Operation();
            operation1.setOperationDate(LocalDate.now());
            operation1.setAmount(new BigDecimal("200.00"));
            operation1.setType(OperationType.valueOf("CREDIT"));
            operation1.setBankAccount(account1);
            operationRepository.save(operation1);

            Operation operation2 = new Operation();
            operation2.setOperationDate(LocalDate.now());
            operation2.setAmount(new BigDecimal("100.00"));
            operation2.setType(OperationType.valueOf("DEBIT"));
            operation2.setBankAccount(account2);
            operationRepository.save(operation2);
        };
    }
}
