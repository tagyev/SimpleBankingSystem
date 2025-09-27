package com.example.SimpleBankingSystem.dto.request;

import com.example.SimpleBankingSystem.enums.TransactionStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class TransactionLogRequest {
    @NotBlank
    Long userId;
    @NotBlank
    Long accountId;
    TransactionStatus status;
}

