package com.example.SimpleBankingSystem.controller;

import com.example.SimpleBankingSystem.dto.request.AccountRequest;
import com.example.SimpleBankingSystem.dto.request.UpdateAccountRequest;
import com.example.SimpleBankingSystem.dto.response.AccountResponse;
import com.example.SimpleBankingSystem.service.abstraction.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @PostMapping
    public AccountResponse createAccount(@Valid @RequestBody AccountRequest request) {
        return accountService.createAccount(request);
    }


    @PutMapping("/{id}/deposit")
    public AccountResponse deposit(
            @PathVariable Long id,
           @Valid @RequestBody UpdateAccountRequest request) {
        return accountService.deposit(id,request);
    }


    @PutMapping("/{id}/withdraw")
    public AccountResponse withdraw(
            @PathVariable Long id,
            @Valid @RequestBody UpdateAccountRequest request) {
        return accountService.withdraw(id,request);
    }


    @PutMapping("/transfer")
    public AccountResponse transfer(
            @RequestParam Long fromId,
            @RequestParam Long toId,
           @Valid @RequestBody UpdateAccountRequest request) {
        return accountService.transfer(fromId,toId,request);
    }
}
