package com.example.template.service;

import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List findAll(){
        return productRepo.findAll();
    }

}
