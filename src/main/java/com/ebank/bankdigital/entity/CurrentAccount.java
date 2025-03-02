package com.ebank.bankdigital.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

/**
 * Entité représentant un compte courant.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CurrentAccount extends BankAccount {

    /**
     * Découvert autorisé pour le compte courant.
     */
    @NotNull
    @Min(0)
    private BigDecimal overdraft;
}
