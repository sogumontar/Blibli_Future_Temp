package com.medan.sitoluama.Del.Kindle.service;

import com.medan.sitoluama.Del.Kindle.Model.Product;
import com.medan.sitoluama.Del.Kindle.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
