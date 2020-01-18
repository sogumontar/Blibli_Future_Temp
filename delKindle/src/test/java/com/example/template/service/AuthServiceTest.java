package com.example.template.service;

import com.example.template.model.SeqUser;
import com.example.template.model.User;
import com.example.template.payload.JwtAuthenticationResponse;
import com.example.template.payload.LoginRequest;
import com.example.template.payload.SignUpRequest;
import com.example.template.repository.UserRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class AuthServiceTest {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
    @Mock
    UserRepository userRepository;
    @Mock
    public LoginRequest loginRequest;
    @Mock
    public SignUpRequest signUpRequest;
    @Mock
    SeqUser seqUser;
    @Mock
    SeqUserService seqUserService;
    @InjectMocks
    AuthService authService;

    @Test
    public void testAuthenticateUser(){
        ResponseEntity responseEntity;

        Mockito.when(loginRequest.getUsername()).thenReturn("hendra");
        Mockito.when(loginRequest.getPassword()).thenReturn("hendra");
        Mockito.when(signUpRequest.getUsername()).thenReturn("hendra");
        assertEquals("hendra",signUpRequest.getUsername());
        assertEquals("hendra",loginRequest.getUsername());
        assertEquals("hendra",loginRequest.getPassword());
//        Mockito.verify(userRepository).save(any(User.class));
//        Mockito.verify(userRepository.existsByUsername(signUpRequest.getUsername()));
//        Mockito.when(authService.authenticateUser(loginRequest)).thenReturn(ResponseEntity.ok());
    }

//    @Test
//    public void testRegisterUser(){
//
//    }
//
//    @Test
//    public void testRegister1(){
//
//    }

}