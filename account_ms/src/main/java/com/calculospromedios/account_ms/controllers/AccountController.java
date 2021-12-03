package com.calculospromedios.account_ms.controllers;

import com.calculospromedios.account_ms.exceptions.AccountNotFoundException;
import com.calculospromedios.account_ms.models.Account;
import com.calculospromedios.account_ms.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts/{codigo}")
    Account getAccount(@PathVariable String codigo){
        return accountRepository.findById(codigo)
                .orElseThrow(() -> new AccountNotFoundException("No se encontro una cuenta con el codigo: " + codigo));
    }
    @PostMapping("/accounts")
    Account newAccount(@RequestBody Account account){
        return accountRepository.save(account);
    }

    @DeleteMapping("/accounts/{codigo}")
    void deleteAccount(@PathVariable String codigo){
         Account accountToRemove = accountRepository.findById(codigo)
                 .orElseThrow(() -> new AccountNotFoundException("No se encontro una cuenta con el codigo: " + codigo));
         accountRepository.delete(accountToRemove);
    }
}
