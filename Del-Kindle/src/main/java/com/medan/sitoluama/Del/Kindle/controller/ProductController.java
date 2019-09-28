package com.medan.sitoluama.Del.Kindle.controller;

import com.medan.sitoluama.Del.Kindle.Model.Product;
import com.medan.sitoluama.Del.Kindle.repository.ProductRepository;

import com.medan.sitoluama.Del.Kindle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/get")
    public Product findFirstById(Long id){
        return productService.findFirstById(id);
    }

    @CrossOrigin
    @GetMapping("/coba")
    public String coba(){
        return "coba";
    }

    @CrossOrigin
    @PostMapping(value= "/tambah", produces = "application/json")
    public Product tambah(@Valid @RequestBody Product product){
        return productService.save(product);
    }
}
