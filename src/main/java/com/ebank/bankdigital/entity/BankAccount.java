package com.ebank.bankdigital.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String accountNumber;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AccountStatus status;

    @NotNull
    @Size(min = 1, max = 3)
    private String currency;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull
    private Customer customer;


    // Constructeur avec arguments
    public BankAccount(Customer customer, LocalDate createdAt, BigDecimal balance, AccountStatus status, String currency) {
        this.customer = customer;
        this.createdAt = createdAt;
        this.balance = balance;
        this.status = status;
        this.currency = currency;
    }
}
