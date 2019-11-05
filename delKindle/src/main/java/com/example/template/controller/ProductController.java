package com.example.template.controller;

import com.example.template.model.Account;
import com.example.template.model.Product;
import com.example.template.payload.ProductRequest;
import com.example.template.payload.RegisterRequest;
import com.example.template.repository.ProductRepo;
import com.example.template.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;


    @Autowired
    ProductService productService;

    @CrossOrigin
    @RequestMapping("/")
    public List findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @RequestMapping("/insert")
    public Product save(@Valid @RequestBody ProductRequest productRequest){
        Product product=new Product(
                productRequest.getTitle(),
                productRequest.getDescription(),
                productRequest.getCategories(),
                productRequest.getPublicationYear(),
                productRequest.getPrice(),
                productRequest.getAuthor(),
                productRequest.getIsbn(),
                productRequest.getPublisher());
        return productRepo.save(product);
    }

}
