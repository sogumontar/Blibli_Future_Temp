package com.example.template.service;

import com.example.template.model.Wishlist;
import com.example.template.repository.WishlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    WishlistRepo wishlistRepo;
    public Integer check(String skuUser,String skuProduct){
        return wishlistRepo.existsBySku_userAndSku_product(skuUser,skuProduct);
    }
    public List findAll(){
        return wishlistRepo.findAll();
    }
    Date obDate = new Date();
    SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");



    public Wishlist save(Wishlist wishlist){
        Wishlist wishlist1=new Wishlist(
                obDateFormat.format(obDate.getTime()).toString(),
                wishlist.getStatus(),
                wishlist.getTitle(),
                wishlist.getPict_product(),
                wishlist.getCategories(),
                wishlist.getPublication_year(),
                wishlist.getPrice(),
                wishlist.getAuthor(),
                wishlist.getPublisher(),
                wishlist.getIsbn(),
                wishlist.getSku_user(),
                wishlist.getSku_product()
        );
        return  wishlistRepo.save(wishlist1);
    }

    public Wishlist findFirstById(Integer id){
        return wishlistRepo.findFirstById(id);
    }

}
