package com.example.SimpleBankingSystem.dao.entity;

import com.example.SimpleBankingSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "transactions")
@FieldDefaults(level = PRIVATE)
public class TransactionLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long userId;

    Long accountId;

    BigDecimal amount;

    @Enumerated(EnumType.STRING)
    TransactionStatus status;

    @CreationTimestamp
    LocalDateTime createdAt;

}
