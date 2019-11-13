package com.example.template.service;


import com.example.template.model.Product;
import com.example.template.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List findAll(){
        return productRepository.findAll();
    }

    public Product findFirstById(Long id){
        return productRepository.findFirstById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }



}
