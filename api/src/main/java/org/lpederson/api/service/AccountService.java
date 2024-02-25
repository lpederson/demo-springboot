package org.lpederson.api.service;

import lombok.extern.slf4j.Slf4j;
import org.lpederson.common.entity.Account;
import org.lpederson.common.kafka.KafkaConfig;
import org.lpederson.common.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(KafkaConfig.TOPIC, msg);
    }

    public List<Account> getAllEmployees() {
        sendMessage("fetched all accounts");
        return accountRepo.findAll();
    }

    public Account getEmployeeById(Integer id) {
        Optional<Account> optionalEmployee = accountRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        }
        log.info("Account with id: {} doesn't exist", id);
        return null;
    }

    public Account saveAccount(Account account) {
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        Account savedAccount = accountRepo.save(account);

        log.info("Account with id: {} saved successfully", account.getId());
        return savedAccount;
    }

    public Account updateAccount(Account account) {
        Optional<Account> existingAccount = accountRepo.findById(account.getId());
        account.setCreatedAt(existingAccount.get().getCreatedAt());
        account.setUpdatedAt(LocalDateTime.now());

        Account updatedAccount = accountRepo.save(account);

        log.info("Account with id: {} updated successfully", account.getId());
        return updatedAccount;
    }

    public void deleteAccountById(Integer id) {
        accountRepo.deleteById(id);
    }

}
