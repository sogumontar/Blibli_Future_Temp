package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.CartRepo;
import com.example.template.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CartService cartService;

//    @CrossOrigin
//    @GetMapping("/all")
//    public List findAllById_user(){
//
//        TypedQuery<Product>query= entityManager.createQuery("SELECT pr FROM product pr join cart cr on pr.id=cr.id_product",Product.class);
//        List<Product> result= query.getResultList() ;
//        return result;
//    }
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
