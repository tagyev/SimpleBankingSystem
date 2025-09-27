package com.example.SimpleBankingSystem.controller;

import com.example.SimpleBankingSystem.dto.request.TransactionLogRequest;
import com.example.SimpleBankingSystem.dto.response.TransactionLogResponse;
import com.example.SimpleBankingSystem.service.abstraction.TransactionLogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TransactionLogController {
    TransactionLogService transactionLogService;


    @PostMapping
    public TransactionLogResponse create(@Valid @RequestBody TransactionLogRequest request) {
        return transactionLogService.create(request);
    }


    @GetMapping("/{id}")
    public TransactionLogResponse getById(@PathVariable Long id) {
        return transactionLogService.getById(id);
    }
}
