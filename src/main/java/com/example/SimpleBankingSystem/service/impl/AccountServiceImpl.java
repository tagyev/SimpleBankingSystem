package com.example.SimpleBankingSystem.service.impl;

import com.example.SimpleBankingSystem.dao.entity.AccountEntity;
import com.example.SimpleBankingSystem.dao.entity.TransactionLogEntity;
import com.example.SimpleBankingSystem.dao.entity.UserEntity;
import com.example.SimpleBankingSystem.dao.repository.AccountRepository;
import com.example.SimpleBankingSystem.dao.repository.TransactionRepository;
import com.example.SimpleBankingSystem.dao.repository.UserRepository;
import com.example.SimpleBankingSystem.dto.request.AccountRequest;
import com.example.SimpleBankingSystem.dto.request.UpdateAccountRequest;
import com.example.SimpleBankingSystem.dto.response.AccountResponse;
import com.example.SimpleBankingSystem.enums.TransactionStatus;
import com.example.SimpleBankingSystem.exception.AccountNotFoundException;
import com.example.SimpleBankingSystem.exception.InsufficientBalanceException;
import com.example.SimpleBankingSystem.exception.InvalidAmountException;
import com.example.SimpleBankingSystem.exception.UserNotFoundException;
import com.example.SimpleBankingSystem.mapper.AccountMapping;
import com.example.SimpleBankingSystem.service.abstraction.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {
    AccountRepository repository;
    UserRepository userRepository;
    TransactionRepository transactionLogRepository;

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        UserEntity userEntity = fetchUserIfExist(request.getUserId());
        AccountEntity accountEntity = AccountMapping.requestToEntity(request);
        repository.save(accountEntity);

        TransactionLogEntity log = TransactionLogEntity.builder()
                .userId(userEntity.getId())
                .accountId(accountEntity.getId())
                .status(TransactionStatus.CREATED)
                .build();
        transactionLogRepository.save(log);

        return AccountMapping.entityToResponse(accountEntity);
    }

    @Override
    public AccountResponse deposit(Long id, UpdateAccountRequest request) {
        if (request.getAmount().compareTo(BigDecimal.ZERO)<0)
            throw new InvalidAmountException("Deposit amount must be greater than zero");
        AccountEntity accountEntity = fetchAccountIfExist(id);
        accountEntity.setBalance(accountEntity.getBalance().add(request.getAmount()));
        repository.save(accountEntity);

        TransactionLogEntity log = TransactionLogEntity.builder()
                .userId(accountEntity.getUserId()) // AccountEntity-də userId varsa
                .accountId(accountEntity.getId())
                .status(TransactionStatus.DEPOSIT)
                .build();
        transactionLogRepository.save(log);

        return AccountMapping.entityToResponse(accountEntity);
    }

    @Override
    public AccountResponse withdraw(Long id, UpdateAccountRequest request) {
        if (request.getAmount().compareTo(BigDecimal.ZERO)<0)
            throw new InvalidAmountException("Withdraw amount must be greater than zero");
        AccountEntity accountEntity = fetchAccountIfExist(id);
        accountEntity.setBalance(accountEntity.getBalance().subtract(request.getAmount()));
        repository.save(accountEntity);

        TransactionLogEntity log = TransactionLogEntity.builder()
                .userId(accountEntity.getUserId())
                .accountId(accountEntity.getId())
                .status(TransactionStatus.WITHDRAW)
                .build();
        transactionLogRepository.save(log);

        return AccountMapping.entityToResponse(accountEntity);
    }

    @Transactional
    @Override
    public AccountResponse transfer(Long fromId,Long toId, UpdateAccountRequest request) {
        AccountEntity fromAccount = fetchAccountIfExist(fromId);
        AccountEntity toAccount = fetchAccountIfExist(toId);
        if (fromAccount.getBalance().compareTo(request.getAmount())<0)
            throw new InsufficientBalanceException("Insufficient balance");
        if (request.getAmount().compareTo(BigDecimal.ZERO)<0)
            throw new InvalidAmountException("Transfer amount must be greater than zero");
        if (fromAccount.getBalance().compareTo(request.getAmount())>0 &&
                                        request.getAmount().compareTo(BigDecimal.ZERO)>0)
            fromAccount.setBalance(fromAccount.getBalance().subtract(request.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(request.getAmount()));
        repository.save(fromAccount);
        repository.save(toAccount);

        TransactionLogEntity fromLog = TransactionLogEntity.builder()
                .userId(fromAccount.getUserId())
                .accountId(fromAccount.getId())
                .status(TransactionStatus.TRANSFER)
                .build();

        TransactionLogEntity toLog = TransactionLogEntity.builder()
                .userId(toAccount.getUserId())
                .accountId(toAccount.getId())
                .status(TransactionStatus.TRANSFER)
                .build();

        transactionLogRepository.save(fromLog);
        transactionLogRepository.save(toLog);
        return AccountMapping.entityToResponse(fromAccount);
    }

    private AccountEntity fetchAccountIfExist(Long id){
        return repository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("Account not found! " + id));
    }
    private UserEntity fetchUserIfExist(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found! " + id));
    }
}
