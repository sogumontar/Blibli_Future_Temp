package com.example.template.service;

import com.example.template.model.User;
import com.example.template.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class UserServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    UserRepository userRepository;
    @Mock
    User user;
    @InjectMocks
    UserService userService;

    @Test
    public void testFindAll(){
        List list=new ArrayList<>();

        list.add(user.getRoles());
        list.add(user.getSku());
        list.add(user.getPassword());
        list.add(user.getUsername());
        list.add(user.getEmail());
        list.add(user.getName());
        list.add(user.getRoles());
        list.add(user.getStatus());
        list.add(user.getAlamat());
        list.add(user.getTanggal_lahir());
        list.add(user.getTelepon());
        list.add(user.getCreated_at());
        list.add(user.getUpdated_at());

        Mockito.when(userRepository.findAll()).thenReturn(list);
        assertEquals(list,userService.findAll());
        Mockito.verify(userRepository).findAll();

    }

    @Test
    public void testFindByName(){
        Mockito.when(user.getName()).thenReturn("Hendra");
        assertEquals("Hendra",user.getName());
        List list=new ArrayList<>();
        list.add(user.getRoles());
        list.add(user.getSku());
        list.add(user.getPassword());
        list.add(user.getUsername());
        list.add(user.getEmail());
        list.add(user.getName());
        list.add(user.getRoles());
        list.add(user.getStatus());
        list.add(user.getAlamat());
        list.add(user.getTanggal_lahir());
        list.add(user.getTelepon());
        list.add(user.getCreated_at());
        list.add(user.getUpdated_at());
        Mockito.when(userRepository.findByName(user.getName())).thenReturn(list);
        assertEquals(list,userService.findByName(user.getName()));
        Mockito.verify(userRepository).findByName(user.getName());
    }

    @Test
    public void testSave(){
        user=new User();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.save(user));
    }

    @Test
    public void testFindBySku(){
        Mockito.when(user.getSku()).thenReturn("HEND-001-PROD-001");
        assertEquals("HEND-001-PROD-001",user.getSku());
        user=new User();
        Mockito.when(userRepository.findBySku(user.getSku())).thenReturn(user);
        assertEquals(user,userService.findBySku(user.getSku()));
        Mockito.verify(userRepository).findBySku(user.getSku());
    }

    @Test
    public void testUpdateStatusActive(){
        Mockito.when(user.getSku()).thenReturn("SKU_USER");
        Mockito.when(userRepository.findBySku(user.getSku())).thenReturn(user);
        user=userRepository.findBySku(user.getSku());
        Mockito.when(userRepository.save(user)).thenReturn(user);
        assertEquals(user,userService.updateStatusabalock(user.getSku()));
//        Mockito.verify(userRepository).findBySku(user.getSku());
    }

    @Test
    public void testUpdateStatusabalock(){
        //Mockito.when(user.getSku()).thenReturn("SKU_USER");
        User user = new User();
        user.setSku("SKU_USER");
        Mockito.when(userRepository.findBySku("SKU_USER")).thenReturn(user);
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);
        assertEquals(user,userService.updateStatusabalock("SKU_USER"));
        Mockito.verify(userRepository).save(any(User.class));
        Mockito.verify(userRepository).findBySku("SKU_USER");
    }
    @Test
    public void testUpdateProfile(){
        Mockito.when(user.getName()).thenReturn("name");
        Mockito.when(user.getEmail()).thenReturn("email");
        Mockito.when(user.getUsername()).thenReturn("username");
        Mockito.when(user.getTelepon()).thenReturn("telepon");
        Mockito.when(user.getAlamat()).thenReturn("alamat");
        Mockito.when(user.getSku()).thenReturn("sku");
//        Mockito.when(userService.updateProfile(user.getName(),user.getEmail(),user.getUsername(),user.getTelepon(),user.getAlamat(),user.getSku())).thenReturn("Sukses");
//        assertEquals("Sukses",userService.updateProfile(user.getName(),user.getEmail(),user.getUsername(),user.getTelepon(),user.getAlamat(),user.getSku()));

//        Mockito.verify(userRepository).update( "name", "email", "username", "telepon"," alamat"," sku");
    }
}