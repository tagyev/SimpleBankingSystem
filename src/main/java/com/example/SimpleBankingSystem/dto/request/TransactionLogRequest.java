package com.example.SimpleBankingSystem.dto.request;

import com.example.SimpleBankingSystem.enums.TransactionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TransactionLogRequest {
    @NotNull
    Long userId;
    @NotNull
    Long accountId;
    TransactionStatus status;
}

