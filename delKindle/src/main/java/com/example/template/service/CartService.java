package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public List findAll(){
        return cartRepo.findAll();
    }
    public Cart save(Cart cart){
        return  cartRepo.save(cart);
    }
//    public List findById_product(Integer idProduct){
//        return cartRepo.findAllById_product(idProduct);
//    }
    public Cart findFirstById(Integer id){
        return cartRepo.findFirstById(id);
    }
//    public List dat(){
//        return cartRepo.dat();
//    };

}
