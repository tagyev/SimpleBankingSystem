package com.example.SimpleBankingSystem.dao.repository;

import com.example.SimpleBankingSystem.dao.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
}
