package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    public List findAllById_user(Integer id_user){
        return cartRepo.findAllById_user(id_user);
    }
    public Cart save(Cart cart){
        return  cartRepo.save(cart);
    }

}
