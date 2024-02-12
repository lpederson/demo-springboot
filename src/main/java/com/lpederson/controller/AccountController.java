package com.lpederson.controller;

import com.lpederson.entity.Account;
import com.lpederson.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/accounts/v1")
@RequiredArgsConstructor
@Validated
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok().body(accountService.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(accountService.getEmployeeById(id));
    }


    @PostMapping("/")
    public ResponseEntity<Account> saveEmployee(@RequestBody Account account) {
        return ResponseEntity.ok().body(accountService.saveAccount(account));
    }

    @PutMapping("/")
    public ResponseEntity<Account> updateEmployee(@RequestBody Account account) {
        return ResponseEntity.ok().body(accountService.updateAccount(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Integer id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().body("Deleted account successfully");
    }


}
