package com.example.SimpleBankingSystem.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UserRequest {

    @NotBlank
    @Max(30)
    @Min(2)
    String firstName;

    @NotBlank
    @Max(30)
    @Min(2)
    String lastName;

    @NotBlank
    @Min(18)
    @Positive
    Integer age;

}
