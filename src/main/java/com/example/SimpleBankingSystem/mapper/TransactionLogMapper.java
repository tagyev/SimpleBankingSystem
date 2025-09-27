package com.example.SimpleBankingSystem.mapper;

import com.example.SimpleBankingSystem.dao.entity.TransactionLogEntity;
import com.example.SimpleBankingSystem.dto.request.TransactionLogRequest;
import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;

public class TransactionLogMapper {
    public static TransactionLogResponse entityToResponse(TransactionLogEntity entity) {
        return TransactionLogResponse.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .accountId(entity.getAccountId())
                .amount(entity.getAmount())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }
}
