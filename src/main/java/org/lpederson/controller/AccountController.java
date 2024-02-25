package org.lpederson.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lpederson.entity.Account;
import org.lpederson.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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

import static org.lpederson.kafka.KafkaConfig.TOPIC;


@RestController
@RequestMapping("/accounts/v1")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AccountController {
    private final AccountService accountService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info("sending a message");
        kafkaTemplate.send(TOPIC, msg);
    }

    @GetMapping("/")
    public ResponseEntity<List<Account>> getAllAccounts() {
        sendMessage("fetched all accounts");
        return ResponseEntity.ok().body(accountService.getAllEmployees());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(accountService.getEmployeeById(id));
    }


    @PostMapping("/")
    public ResponseEntity<Account> saveEmployee(@RequestBody Account account) {
        sendMessage("saved an account");
        return ResponseEntity.ok().body(accountService.saveAccount(account));
    }

    @PutMapping("/")
    public ResponseEntity<Account> updateEmployee(@RequestBody Account account) {
        sendMessage("account was updated." + account);
        return ResponseEntity.ok().body(accountService.updateAccount(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Integer id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().body("Deleted account successfully");
    }


}
