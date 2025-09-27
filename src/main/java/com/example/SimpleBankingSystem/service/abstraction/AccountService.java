package com.example.SimpleBankingSystem.service.abstraction;

import com.example.SimpleBankingSystem.dto.request.AccountRequest;
import com.example.SimpleBankingSystem.dto.request.UpdateAccountRequest;
import com.example.SimpleBankingSystem.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse createAccount(AccountRequest request);

    AccountResponse deposit(Long id, UpdateAccountRequest request);

    AccountResponse withdraw(Long id, UpdateAccountRequest request);

    AccountResponse transfer(Long fromId,Long toId, UpdateAccountRequest request);

}
