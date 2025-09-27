package com.example.SimpleBankingSystem.service.impl;

import com.example.SimpleBankingSystem.dao.entity.UserEntity;
import com.example.SimpleBankingSystem.dao.repository.UserRepository;
import com.example.SimpleBankingSystem.dto.request.UpdateUserRequest;
import com.example.SimpleBankingSystem.dto.request.UserRequest;
import com.example.SimpleBankingSystem.dto.response.UserResponse;
import com.example.SimpleBankingSystem.enums.UserStatus;
import com.example.SimpleBankingSystem.exception.UserNotFoundException;
import com.example.SimpleBankingSystem.mapper.UserMapping;
import com.example.SimpleBankingSystem.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository repository;

    @Override
    public UserResponse createUser(UserRequest request) {
        UserEntity userEntity = UserMapping.requestToEntity(request);
        repository.save(userEntity);
        return UserMapping.entityToResponse(userEntity);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        UserEntity userEntity = fetchUserIfExist(id);
        if (request.getFirstName() != null && !request.getFirstName().isEmpty())
            userEntity.setFirstName(request.getFirstName());
        if (request.getLastName() != null && !request.getLastName().isEmpty())
            userEntity.setLastName(request.getLastName());
        if (request.getAge() !=null)
            userEntity.setAge(request.getAge());
        repository.save(userEntity);
        return UserMapping.entityToResponse(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        UserEntity userEntity = fetchUserIfExist(id);
        userEntity.setStatus(UserStatus.DELETED);
        repository.save(userEntity);
    }

    @Override
    public UserResponse findUserById(Long id) {
        UserEntity userEntity = fetchUserIfExist(id);
        return UserMapping.entityToResponse(userEntity);
    }

    private UserEntity fetchUserIfExist(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found! " + id));
    }
}
