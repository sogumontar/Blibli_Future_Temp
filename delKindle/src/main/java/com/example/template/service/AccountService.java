package com.example.template.service;

import com.example.template.model.Account;
import com.example.template.repository.AccountRepo;
import com.example.template.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public List findAll(){
        return accountRepo.findAll();
    }

    public Account save(Account account){
        return accountRepo.save(account);
    }
}
