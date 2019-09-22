package com.medan.sitoluama.Del.Kindle.controller;

import com.medan.sitoluama.Del.Kindle.Model.Product;
import com.medan.sitoluama.Del.Kindle.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @GetMapping("/get")
    public List findAll(){
        return productRepository.findAll();
    }
    @GetMapping("/coba")
    public String coba(){
        return "coba";
    }

    @PostMapping(value= "/tambah", produces = "application/json")
    public Product tambah(@Valid @RequestBody Product product){
        return productRepository.save(product);
    }
}
