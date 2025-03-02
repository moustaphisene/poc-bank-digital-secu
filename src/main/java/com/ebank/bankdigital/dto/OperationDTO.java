package com.ebank.bankdigital.dto;

import com.ebank.bankdigital.entity.OperationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class OperationDTO {

    private Long id;

    @NotNull
    @PastOrPresent
    private LocalDate date;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private OperationType type;
}
