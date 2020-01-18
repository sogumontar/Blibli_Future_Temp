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

@Ignore
public class SeqProductServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    SeqUserRepository seqUserRepository;
    @Mock
    SeqUser seqUser;
    @InjectMocks
    SeqUserService seqUserService;

    @Test
    public void testSave(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY");
        Mockito.when(seqUser.getLast_seq()).thenReturn("LAST_SEQ");
        assertEquals("KEY",seqUser.getKey());
        assertEquals("LAST_SEQ",seqUser.getLast_seq());
        seqUser = new SeqUser(
                seqUser.getKey(),
                seqUser.getLast_seq()
        );
        Mockito.when(seqUserRepository.save(seqUser)).thenReturn(seqUser);
        assertEquals(seqUser,seqUserService.save(seqUser));
        Mockito.verify(seqUserRepository).save(seqUser);


    }

    @Test
    public void testExistByKey(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY");
        Mockito.when(seqUser.getLast_seq()).thenReturn("LAST_SEQ");
        assertEquals("KEY",seqUser.getKey());
        assertEquals("LAST_SEQ",seqUser.getLast_seq());
        seqUser = new SeqUser(
                seqUser.getKey(),
                seqUser.getLast_seq()
        );
        Mockito.when(seqUserRepository.existsByKey(seqUser.getKey())).thenReturn(TRUE);
        assertEquals(TRUE,seqUserService.existByKey(seqUser.getKey()));
        Mockito.verify(seqUserRepository).existsByKey(seqUser.getKey());
    }

    @Test
    public void testFindFirstByKey(){
        Mockito.when(seqUser.getKey()).thenReturn("KEY");
        Mockito.when(seqUser.getLast_seq()).thenReturn("LAST_SEQ");
        assertEquals("KEY",seqUser.getKey());
        assertEquals("LAST_SEQ",seqUser.getLast_seq());
        seqUser = new SeqUser(
                seqUser.getKey(),
                seqUser.getLast_seq()
        );
        Mockito.when(seqUserRepository.findFirstByKey(seqUser.getKey())).thenReturn(seqUser);
        assertEquals(seqUser,seqUserService.findFirstByKey(seqUser.getKey()));
        Mockito.verify(seqUserRepository).findFirstByKey(seqUser.getKey());
    }


}