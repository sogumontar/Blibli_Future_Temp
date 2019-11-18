package com.example.template.repository;

import com.example.template.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AccountRepo extends JpaRepository<Account,String> {
    //    Account findFirstByUsernameOrEmail(String usernameOrEmail);
    List findAll();
    Account findFirstById(Long id);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}