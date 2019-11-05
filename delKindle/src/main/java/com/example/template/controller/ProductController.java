package com.example.template.controller;

import com.example.template.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping("/")
    public ModelAndView coba(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @CrossOrigin
    @GetMapping("/coba")
    public String get(){
        return "berhasil";
    }
    @CrossOrigin
    @GetMapping("/get")
    public List findAll(){
        return productService.findAll();
    }
}
