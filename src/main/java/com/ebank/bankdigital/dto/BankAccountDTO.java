package com.ebank.bankdigital.dto;

import com.ebank.bankdigital.entity.AccountStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


public class BankAccountDTO {
    private Long id;
    @NotNull
    private LocalDate createdAt;
    @NotNull
    @Min(0)
    private BigDecimal balance;
    @NotNull
    private AccountStatus status;
    @NotNull
    @Size(min = 1, max = 3)
    private String currency;

    // Constructeur par défaut
    public BankAccountDTO() {
    }

    // Constructeur avec tous les champs
    public BankAccountDTO(Long id, LocalDate createdAt, BigDecimal balance, AccountStatus status, String currency) {
        this.id = id;
        this.createdAt = createdAt;
        this.balance = balance;
        this.status = status;
        this.currency = currency;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
