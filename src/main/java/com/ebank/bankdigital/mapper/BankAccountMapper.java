package com.ebank.bankdigital.mapper;

import com.ebank.bankdigital.dto.BankAccountDTO;
import com.ebank.bankdigital.dto.OperationDTO;
import com.ebank.bankdigital.entity.BankAccount;
import com.ebank.bankdigital.entity.Operation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BankAccountMapper {
    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    BankAccountDTO toDTO(BankAccount account);
    BankAccount toEntity(BankAccountDTO dto);

    OperationDTO toDTO(Operation operation);
    Operation toEntity(OperationDTO dto);
}
