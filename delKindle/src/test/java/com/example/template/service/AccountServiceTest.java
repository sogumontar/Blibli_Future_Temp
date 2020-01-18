package com.example.template.service;

import com.example.template.model.Account;
import com.example.template.repository.AccountRepo;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    public Account account;
    @Mock
    private AccountRepo accountRepo;
    @InjectMocks
    public AccountService accountService;

    @Test
    public void testFindAll(){
        List list=new ArrayList();
        Mockito.when(accountRepo.findAll()).thenReturn(list);
        assertEquals(list,accountService.findAll());
        Mockito.verify(accountRepo).findAll();
    }
    @Test
    public void testFindFirstById(){
        Mockito.when(account.getId()).thenReturn(1L);
        assertEquals(1L,account.getId());
        Mockito.when(accountRepo.findFirstById(account.getId())).thenReturn(account);
        assertEquals(account,accountService.findFirstById(account.getId()));
        Mockito.verify(accountRepo).findFirstById(account.getId());
    }
    @Test
    public void testSave(){
        Mockito.when(accountRepo.save(account)).thenReturn(account);
        assertEquals(account,accountService.save(account));
        Mockito.verify(accountRepo).save(account);
    }

}