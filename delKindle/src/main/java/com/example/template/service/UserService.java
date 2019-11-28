package com.example.template.service;

import com.example.template.model.User;
import com.example.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List findAll(){
        return userRepository.findAll();
    }

    public List findByName(String name){
        return userRepository.findByName(name);
    }

    public User save(User user){
        return userRepository.save(user);
    }


    public User findBySku(String sku){
        return userRepository.findBySku(sku);
    }

    public User updateStatusActive(String sku){
        User user = userRepository.findBySku(sku);
        user.setStatus(1);
        return userRepository.save(user);
    }

    public User updateStatusabalock(String sku){
        User user = userRepository.findBySku(sku);
        user.setStatus(0);
        return userRepository.save(user);
    }


}
