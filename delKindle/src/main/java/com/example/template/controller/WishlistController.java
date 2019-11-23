package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.model.Wishlist;
import com.example.template.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;


    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return wishlistService.findAll();
    }


    @CrossOrigin
    @PostMapping("/add")
    public Wishlist save(@RequestBody Wishlist wishlist){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Wishlist wishlist1=new Wishlist(
                wishlist.getId_user(),wishlist.getId_product(),wishlist.getStatus(),obDateFormat.format(obDate.getTime()).toString()
        );
        return wishlistService.save(wishlist1);
    }


}
