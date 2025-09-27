package com.example.SimpleBankingSystem.dto.response;

import com.example.SimpleBankingSystem.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class TransactionLogResponse {
    Long id;
    Long userId;
    Long accountId;
    TransactionStatus status;
    LocalDateTime createdAt;
}
