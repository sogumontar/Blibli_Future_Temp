package com.example.template.service;

import com.example.template.model.SeqUser;
import com.example.template.repository.SeqUserRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

public class SeqUserServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    SeqUser seqUser;
    @Mock
    SeqUserRepository seqUserRepository;
    @InjectMocks
    SeqUserService seqUserService;

    @Test
    public void testExistByKey(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY_USER");
        String expect="KEY_USER";
        assertEquals(expect,seqUser.getKey());
        Mockito.when(seqUserRepository.existsByKey(seqUser.getKey())).thenReturn(TRUE);
        assertEquals(TRUE,seqUserService.existByKey(seqUser.getKey()));
        Mockito.verify(seqUserRepository).existsByKey(seqUser.getKey());
    }

    @Test
    public void testAdd(){
        Mockito.when(seqUserService.add(seqUser.getKey(),seqUser.getLast_seq())).thenReturn(seqUser);
        assertEquals(seqUserService,seqUserService);

    }
    @Test
    public void testFindFirstByKey(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY_USER");
        Mockito.when(seqUser.getLast_seq()).thenReturn("LAST_KEY_USER");
        assertEquals("LAST_KEY_USER",seqUser.getLast_seq());
        String expect="KEY_USER";
        assertEquals(expect,seqUser.getKey());
        seqUser=new SeqUser(seqUser.getKey(),
                seqUser.getLast_seq());
        Mockito.when(seqUserRepository.findFirstByKey(seqUser.getKey())).thenReturn(seqUser);
        assertEquals(seqUser,seqUserService.findFirstByKey(seqUser.getKey()));
        Mockito.verify(seqUserRepository).findFirstByKey(seqUser.getKey());
    }

    @Test
    public void testSave(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY_USER");
        Mockito.when(seqUser.getLast_seq()).thenReturn("LAST_KEY_USER");
        assertEquals("LAST_KEY_USER",seqUser.getLast_seq());
        String expect="KEY_USER";
        assertEquals(expect,seqUser.getKey());
        seqUser=new SeqUser(
                seqUser.getKey(),
                seqUser.getLast_seq()
        );
        Mockito.when(seqUserRepository.save(seqUser)).thenReturn(seqUser);
        assertEquals(seqUser,seqUserService.save(seqUser));
        Mockito.verify(seqUserRepository).save(seqUser);

    }
}