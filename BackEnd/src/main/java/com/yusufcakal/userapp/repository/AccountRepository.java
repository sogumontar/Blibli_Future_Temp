package com.yusufcakal.userapp.repository;

import com.yusufcakal.userapp.model.Account;
import com.yusufcakal.userapp.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findByName(String username);

}
