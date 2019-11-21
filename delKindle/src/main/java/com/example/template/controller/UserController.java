package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.model.User;
import com.example.template.repository.UserRepository;
import com.example.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/getAll")
    public List findAll(){
        return userService.findAll();
    }

    @CrossOrigin
    @GetMapping("/findByName/{name}")
    public List findByName( @PathVariable String name){
        return userService.findByName(name);
    }

    @CrossOrigin
    @GetMapping("/findById/{id}")
    public User findById( @PathVariable Long id){
        return userService.findFirstById(id);
    }

    @CrossOrigin
    @PostMapping("updateStatusActive/{id}")
    public User updateStatusActive(@PathVariable Long id){
        User user = userRepository.findFirstById(id);
        user.setStatus(1);
        return userService.save(user);
    }

    @CrossOrigin
    @PostMapping("updateStatusBlock/{id}")
    public User updateStatusBlock(@PathVariable Long id){
        User user = userRepository.findFirstById(id);
        user.setStatus(0);
        return userService.save(user);
    }
}
