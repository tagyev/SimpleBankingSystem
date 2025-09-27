package com.example.SimpleBankingSystem.service.abstraction;

import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;

public interface TransactionLogService {
        TransactionLogResponse getById(Long id);
}
