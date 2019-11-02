package com.example.template.controller;

import com.example.template.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Api")
public class Controller {

    @Autowired
    SecurityConfig securityConfig;
    @CrossOrigin
    @GetMapping("/")
    public String test(){
        return "Syalom";
    }
}
