package com.example.SimpleBankingSystem.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UpdateUserRequest {
    @Size(min = 2, max = 30)
    String firstName;

    @Size(min = 2, max = 30)
    String lastName;

    @Min(18)
    @Positive
    Integer age;

}
