package com.medan.sitoluama.Del.Kindle.controller;

import com.medan.sitoluama.Del.Kindle.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/buku")
public class BukuController {

    @Autowired
    BukuService bukuService;

    @GetMapping("/caribuku")
    public List findAll(){
        return bukuService.findAll();
    }
}
