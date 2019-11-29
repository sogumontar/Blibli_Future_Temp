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

    public LastProduct save(Integer last_book){
        LastProduct lastProduct = new LastProduct();
        lastProduct.setLast_book(last_book);
        lastProduct.setLast_picture(last_book);
        return lastProductRepository.save(lastProduct);
    }
}
