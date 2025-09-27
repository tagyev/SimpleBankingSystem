package com.example.SimpleBankingSystem.dao.entity;

import com.example.SimpleBankingSystem.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    Long id;

    Long userId;

    Long accountId;

    @Enumerated(EnumType.STRING)
    TransactionStatus status;

    @CreationTimestamp
    LocalDateTime createdAt;

}
