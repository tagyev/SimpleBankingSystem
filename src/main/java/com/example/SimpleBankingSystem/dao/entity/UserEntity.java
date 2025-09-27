package com.example.SimpleBankingSystem.dao.entity;

import com.example.SimpleBankingSystem.enums.UserStatus;
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
@Table(name = "users")
@FieldDefaults(level = PRIVATE)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;

    String lastName;

    Integer age;

    @Enumerated(EnumType.STRING)
    UserStatus status;

    @CreationTimestamp
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;




}
