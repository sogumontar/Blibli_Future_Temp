package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;


    @CrossOrigin
    @GetMapping("/find/{id_user}")
    public List findAllById_user(Integer id_user){
        return cartService.findAllById_user(id_user);
    }

    @CrossOrigin
    @PostMapping("/add")
    public Cart save(@RequestBody Cart cart){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Cart cart1=new Cart(
                cart.getId_user(),cart.getId_product(),obDateFormat.format(obDate.getTime()).toString(),cart.getStatus()
        );
        return cartService.save(cart1);
    }


}
