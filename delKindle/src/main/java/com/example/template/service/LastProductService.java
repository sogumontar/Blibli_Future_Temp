package com.example.template.service;

import com.example.template.model.LastProduct;
import com.example.template.repository.LastProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LastProductService {

    @Autowired
    LastProductRepository lastProductRepository;

    public LastProduct findLast(){
        return lastProductRepository.findLast();
    }
}