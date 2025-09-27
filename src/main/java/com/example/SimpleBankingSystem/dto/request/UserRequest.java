package com.example.SimpleBankingSystem.dto.request;

import jakarta.validation.constraints.*;
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
    @Size(min = 2, max = 30)
    String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    String lastName;

    @NotNull
    @Min(18)
    @Positive
    Integer age;

}
