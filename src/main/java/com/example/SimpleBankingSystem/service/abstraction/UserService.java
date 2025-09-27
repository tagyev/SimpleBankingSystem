package com.example.SimpleBankingSystem.service.abstraction;

import com.example.SimpleBankingSystem.dto.request.UpdateUserRequest;
import com.example.SimpleBankingSystem.dto.request.UserRequest;
import com.example.SimpleBankingSystem.dto.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest request);

    UserResponse updateUser(Long id,UpdateUserRequest request);

    void deleteUser(Long id);

    UserResponse findUserById(Long id);
}
