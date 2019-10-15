package com.yusufcakal.userapp.controller;

import com.yusufcakal.userapp.model.Account;
import com.yusufcakal.userapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import java.util.List;


@RestController
@RequestMapping("/Api")

public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @CrossOrigin
    @GetMapping("/accounts")
    public List<Account>getAllAccounts(){
        return accountRepository.findAll();
    }
    @CrossOrigin
    @GetMapping("/account/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Integer id){
        Account account=accountRepository.findOne(id);
        if(account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(account);
    }

    @CrossOrigin
    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account)
    {
        return accountRepository.save(account);
    }

}
