package com.lpederson.repository;

import com.lpederson.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<Account, Integer> {
}
