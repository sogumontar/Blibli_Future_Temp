package com.medan.sitoluama.Del.Kindle.controller;

import com.medan.sitoluama.Del.Kindle.Model.Product;
import com.medan.sitoluama.Del.Kindle.repository.ProductRepository;

import com.medan.sitoluama.Del.Kindle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List findAll(){
        return productService.findAll();
    }

    @GetMapping("/get")
    public Product findFirstById(Long id){
        return productService.findFirstById(id);
    }
    @GetMapping("/coba")
    public String coba(){
        return "coba";
    }

    @PostMapping(value= "/tambah", produces = "application/json")
    public Product tambah(@Valid @RequestBody Product product){
        return productService.save(product);
    }
}
