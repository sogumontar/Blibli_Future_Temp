package com.example.template.controller;


import com.example.template.service.SeqUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/seqUser")
public class SeqUserController {

    @Autowired
    SeqUserService seqUserService;

    @CrossOrigin
    @GetMapping("/existByKey/{key}")
    public boolean existByKey(@PathVariable String key){
        return seqUserService.existByKey(key);
    }
}
