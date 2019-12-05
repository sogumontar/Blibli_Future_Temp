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
    @GetMapping("/findById/{sku}")
    public User findBySku( @PathVariable String sku){
        return userService.findBySku(sku);
    }

    @CrossOrigin
    @PostMapping("updateStatusActive/{sku}")
    public User updateStatusActive(@PathVariable String sku){
       return userService.updateStatusActive(sku);
    }

    @CrossOrigin
    @PostMapping("updateStatusBlock/{sku}")
    public User updateStatusBlock(@PathVariable String sku){
        return userService.updateStatusabalock(sku);
    }

    @CrossOrigin
    @PutMapping("updateProfile/{sku}")
    public String updateProfile(@PathVariable  String sku){

//        userService.
        return "Update Success";
    }
}
