package com.example.template.service;

import com.example.template.model.Wishlist;
import com.example.template.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;

    public List findAll(){
        return wishlistRepo.findAll();
    }
    public Wishlist save(Wishlist wishlist){
        return  wishlistRepo.save(wishlist);
    }

    public Wishlist findFirstById(Integer id){
        return wishlistRepo.findFirstById(id);
    }

}
