package com.example.template.controller;

import com.example.template.model.Account;
import com.example.template.model.constants.AccountConstant;
import com.example.template.payload.ApiResponse;
//import com.example.template.payload.JwtAuthenticationResponse;
import com.example.template.payload.LoginRequest;
import com.example.template.payload.RegisterRequest;
import com.example.template.repository.AccountRepo;
//import com.example.template.security.JwtAuthenticationFilter;
//import com.example.template.security.JwtTokenProvider;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {
//        @Autowired
//        JwtTokenProvider jwtTokenProvider;
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
        @GetMapping("/test")
        public String test(){
                return "test";
        }

        @CrossOrigin
        @GetMapping("/find/{id}")
        public Account find(@PathVariable Long id){
                return accountService.findFirstById(id);/
        }

//        @CrossOrigin
//        @GetMapping
//        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
//
//                Authentication authentication= authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                loginRequest.getUsernameOrEmail(),
//                                loginRequest.getPassword()
//                        )
//                );
//
//                String jwt= jwtTokenProvider.generateToken(authentication);
//                return  ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//        }

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
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                Account account= new Account(registerRequest.getEmail(),registerRequest.getName(),registerRequest.getUsername(),registerRequest.getPassword(),registerRequest.getCreated_at());
                account.setPassword(passwordEncoder.encode(account.getPassword()));
                account.setCreated_at(dtf.format(now).toString());
                Account result=accountRepo.save(account);

                URI location = ServletUriComponentsBuilder
                        .fromCurrentContextPath().path("/users/{username}")
                        .buildAndExpand(result.getUsername()).toUri();

             return ResponseEntity.created(location).body(new ApiResponse(true, "Account Berhasil ditambahkan"));
        }

}
