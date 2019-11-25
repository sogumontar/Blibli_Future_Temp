package com.example.template.service;

import com.example.template.model.SkuProducts;
import com.example.template.repository.SkuProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkuProductsService {
    @Autowired
    SkuProductsRepo skuProductsRepo;
    public SkuProducts findByKey(String key){
        return skuProductsRepo.findByKey(key);
    }

    public Boolean existsByKey(String key){
        return skuProductsRepo.existsByKey(key);
    }
}
