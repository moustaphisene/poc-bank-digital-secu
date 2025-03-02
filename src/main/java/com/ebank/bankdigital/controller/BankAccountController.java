package com.ebank.bankdigital.controller;

import com.ebank.bankdigital.dto.BankAccountDTO;
import com.ebank.bankdigital.dto.OperationDTO;
import com.ebank.bankdigital.entity.BankAccount;
import com.ebank.bankdigital.entity.Operation;
import com.ebank.bankdigital.mapper.BankAccountMapper;
import com.ebank.bankdigital.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Contrôleur pour la gestion des comptes bancaires et des opérations.
 */
@RestController
@RequestMapping("/api/v1/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccountDTO> createBankAccount(@RequestBody BankAccountDTO dto) {
        Assert.notNull(dto, "BankAccountDTO must not be null");
        BankAccount account = BankAccountMapper.INSTANCE.toEntity(dto);
        BankAccount createdAccount = bankAccountService.createBankAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(BankAccountMapper.INSTANCE.toDTO(createdAccount));
    }

    @PostMapping("/{accountId}/operations")
    public ResponseEntity<OperationDTO> performOperation(@PathVariable Long accountId, @RequestBody OperationDTO dto) {
        Assert.notNull(accountId, "Account ID must not be null");
        Assert.notNull(dto, "OperationDTO must not be null");
        Operation operation = BankAccountMapper.INSTANCE.toEntity(dto);
        Operation performedOperation = bankAccountService.processOperation(accountId, operation);
        return ResponseEntity.ok(BankAccountMapper.INSTANCE.toDTO(performedOperation));
    }
}
