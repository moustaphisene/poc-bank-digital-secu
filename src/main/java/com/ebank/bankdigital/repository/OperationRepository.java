package com.ebank.bankdigital.repository;

import com.ebank.bankdigital.entity.Operation;
import com.ebank.bankdigital.entity.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {


    List<Operation> findByBankAccountId(Long bankAccountId);


    List<Operation> findByType(OperationType type);
}
