package com.example.SimpleBankingSystem.mapper;

import com.example.SimpleBankingSystem.dao.entity.UserEntity;
import com.example.SimpleBankingSystem.dto.request.UserRequest;
import com.example.SimpleBankingSystem.dto.response.UserResponse;
import com.example.SimpleBankingSystem.enums.UserStatus;

import java.time.LocalDateTime;

public class UserMapping {

    public static UserEntity requestToEntity(UserRequest request) {
        UserEntity entity = UserEntity.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .age(request.getAge())
                .status(UserStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();
        return entity;
    }

    public static UserResponse entityToResponse(UserEntity entity){
        UserResponse response = UserResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .build();
        return response;
    }
}
