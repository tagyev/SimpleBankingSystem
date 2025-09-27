package com.example.SimpleBankingSystem.dao.repository;

import com.example.SimpleBankingSystem.dao.entity.TransactionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionLogEntity,Long> {
}
