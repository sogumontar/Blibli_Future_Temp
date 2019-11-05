package com.example.template.controller;

<<<<<<< HEAD
import com.example.template.repository.ProductRepo;
import com.example.template.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;

=======
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
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147

    @Autowired
    ProductService productService;

    @CrossOrigin
<<<<<<< HEAD
    @RequestMapping("/")
    public List findAll(){
        return productService.findAll();
    }

=======
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
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
}
