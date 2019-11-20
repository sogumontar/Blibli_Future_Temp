package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.repository.CartRepo;
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
    @GetMapping("/all")
    public List findAllById_user(){
        System.out.println(AuthController.idLogin);
        idLog(AuthController.idLogin);
        return cartService.findAll();
    }
    public Long idLog(Long log){
        return log;
    }

    @CrossOrigin
    @PostMapping("/add")
    public Cart save(@RequestBody Cart cart){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Cart cart1=new Cart(
                AuthController.idLogin,cart.getId_product(),obDateFormat.format(obDate.getTime()).toString(),cart.getStatus()
        );
        return cartService.save(cart1);
    }


}
