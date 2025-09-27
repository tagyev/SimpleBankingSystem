package com.example.SimpleBankingSystem.mapper;

import com.example.SimpleBankingSystem.dao.entity.AccountEntity;
import com.example.SimpleBankingSystem.dto.request.AccountRequest;
import com.example.SimpleBankingSystem.dto.response.AccountResponse;
import com.example.SimpleBankingSystem.enums.AccountStatus;

public class AccountMapping {
    public static AccountEntity requestToEntity(AccountRequest request) {
        AccountEntity entity = AccountEntity.builder()
                .userId(request.getUserId())
                .balance(request.getBalance())
                .status(AccountStatus.ACTIVE)
                .build();
        return entity;
    }

    public static AccountResponse entityToResponse(AccountEntity entity){
        AccountResponse response = AccountResponse.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .balance(entity.getBalance())
                .build();
        return response;
    }

}
