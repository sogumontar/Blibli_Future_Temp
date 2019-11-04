package com.example.template.controller;

import com.example.template.model.Account;
import com.example.template.model.constants.AccountConstant;
import com.example.template.payload.ApiResponse;
import com.example.template.payload.LoginRequest;
import com.example.template.payload.RegisterRequest;
import com.example.template.repository.AccountRepo;
import com.example.template.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

        @Autowired
        PasswordEncoder passwordEncoder;
        @Autowired
        AccountRepo accountRepo;
        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        AccountService accountService;
        @CrossOrigin
        @GetMapping("/")
        public List findAll()
        {
            return accountService.findAll();
        }

        @CrossOrigin
        @GetMapping
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){

                Authentication authentication= authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.getUsernameOrEmail(),
                                loginRequest.getPassword()
                        )
                );
                return  ResponseEntity.ok(new JwtAuth    )
        }

        @CrossOrigin
        @PostMapping("/register")
        public ResponseEntity<?> save(@Valid  @RequestBody RegisterRequest registerRequest ){
                if(accountRepo.existsByUsername(registerRequest.getUsername())) {
                        return new ResponseEntity(new ApiResponse(false, "Username Sudah digunakan"),
                                HttpStatus.BAD_REQUEST);
                }

                if(accountRepo.existsByEmail(registerRequest.getEmail())) {
                        return new ResponseEntity(new ApiResponse(false, "Email Sudah digunakan"),
                                HttpStatus.BAD_REQUEST);
                }

                Account account= new Account(registerRequest.getEmail(),registerRequest.getName(),registerRequest.getUsername(),registerRequest.getPassword());
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                Account result=accountRepo.save(account);

                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/users/{username}")
                        .buildAndExpand(result.getUsername()).toUri();

             return ResponseEntity.created(location).body(new ApiResponse(true, "Account Berhasil ditambahkan"));
        }

}
