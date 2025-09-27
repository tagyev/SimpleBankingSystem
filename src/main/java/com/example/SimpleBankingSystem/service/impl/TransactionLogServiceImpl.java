package com.example.SimpleBankingSystem.service.impl;

import com.example.SimpleBankingSystem.dao.entity.TransactionLogEntity;
import com.example.SimpleBankingSystem.dao.repository.TransactionRepository;
import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;
import com.example.SimpleBankingSystem.exception.TransactionNotFoundException;
import com.example.SimpleBankingSystem.mapper.TransactionLogMapper;
import com.example.SimpleBankingSystem.service.abstraction.TransactionLogService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TransactionLogServiceImpl implements TransactionLogService {
    TransactionRepository repository;

    @Override
    public TransactionLogResponse getById(Long id) {
        TransactionLogEntity entity = repository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found"));
        return TransactionLogMapper.entityToResponse(entity);
    }


}
