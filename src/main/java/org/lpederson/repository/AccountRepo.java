package org.lpederson.repository;

import org.lpederson.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepo extends JpaRepository<Account, Integer> {
}
