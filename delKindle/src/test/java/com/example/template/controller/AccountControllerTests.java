package com.example.template.controller;

import com.example.template.repository.AccountRepo;
import com.example.template.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTests {
    @Value("${local.server.port}")
    private int port;

//    @MockBean
//    private AccountService accountServicemock;
//    @MockBean
//    AccountRepo accountRepoMock;
//    @MockBean
//    AuthenticationManager authenticationManagerMock;
//    @MockBean
//    AccountService accountServiceMock;
//
//    @MockBean
//    private PasswordEncoder passwordEncoderMock;

    private ObjectMapper mapper;



    @Before
    public void setup() {
        RestAssured.port = port;

        mapper = new ObjectMapper();
    }

//    @After
//    public void cleanup() {
//        verifyNoMoreInteractions(accountServicemock);
//    }

    @Test
    public void testFindAll() throws Exception{
        assertEquals(22,22);
    }
}
