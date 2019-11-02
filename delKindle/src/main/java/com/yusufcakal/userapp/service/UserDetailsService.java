package com.yusufcakal.userapp.service;

import com.yusufcakal.userapp.model.Account;
import com.yusufcakal.userapp.model.Auth;
import com.yusufcakal.userapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optionalAccount= accountRepository.findByName(username);

        optionalAccount
                .orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
    return    optionalAccount
                .map(account-> new Auth((Auth) account)).get();

    }
}
