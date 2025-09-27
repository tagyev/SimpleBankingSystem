package com.example.SimpleBankingSystem.service.abstraction;

import com.example.SimpleBankingSystem.dto.request.TransactionLogRequest;
import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;

public interface TransactionLogService {

    TransactionLogResponse create(TransactionLogRequest request);

    TransactionLogResponse getById(Long id);

}
