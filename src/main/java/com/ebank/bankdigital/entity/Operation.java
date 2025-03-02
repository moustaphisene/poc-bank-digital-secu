package com.ebank.bankdigital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entité représentant une opération bancaire.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Date de l'opération.
     */
    @NotNull
    @PastOrPresent
    private LocalDate operationDate;

    /**
     * Montant de l'opération.
     */
    @NotNull
    private BigDecimal amount;

    /**
     * Description de l'opération.
     */
    private String description;

    /**
     * Type de l'opération.
     */
    @Enumerated(EnumType.STRING)
    @NotNull
    private OperationType type;

    /**
     * Compte bancaire associé à l'opération.
     */
    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    @NotNull
    private BankAccount bankAccount;



    // Constructeur avec arguments
    public Operation(LocalDate date, BigDecimal amount, OperationType type, BankAccount bankAccount) {
        this.operationDate = date;
        this.amount = amount;
        this.type = type;
        this.bankAccount = bankAccount;
    }
}
