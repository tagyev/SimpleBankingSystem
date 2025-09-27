package com.example.SimpleBankingSystem.controller;

import com.example.SimpleBankingSystem.dto.response.ExceptionResponse;
import com.example.SimpleBankingSystem.exception.AccountNotFoundException;
import com.example.SimpleBankingSystem.exception.InsufficientBalanceException;
import com.example.SimpleBankingSystem.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(AccountNotFoundException.class)
    public ExceptionResponse handleAccountNotFound(AccountNotFoundException ex) {
        log.error("Account not found: {}", ex.getMessage(), ex);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details("Account related error")
                .build();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ExceptionResponse handleUserNotFound(UserNotFoundException ex) {
        log.error("User not found: {}", ex.getMessage(), ex);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details("User related error")
                .build();
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ExceptionResponse handleInsufficientBalance(InsufficientBalanceException ex) {
        log.error("Insufficient balance: {}", ex.getMessage(), ex);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .details("Transaction error")
                .build();
    }

    @ExceptionHandler(Exception.class) // catch-all
    public ExceptionResponse handleGlobalException(Exception ex) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message("Internal server error")
                .details("Unexpected error occurred")
                .build();
    }
}

