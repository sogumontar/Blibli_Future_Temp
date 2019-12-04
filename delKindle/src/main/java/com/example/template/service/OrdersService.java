package com.example.template.service;

import com.example.template.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    CartRepo cartRepo;
    public String updateAfterCart(String sku_user){
        cartRepo.akhir(sku_user);
        return "sukses";
    }
}
