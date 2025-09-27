package com.example.SimpleBankingSystem.controller;

import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;
import com.example.SimpleBankingSystem.service.abstraction.TransactionLogService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TransactionLogController {
    TransactionLogService transactionLogService;

    @GetMapping("/{id}")
    public TransactionLogResponse getById(@PathVariable Long id) {
        return transactionLogService.getById(id);
    }
}
