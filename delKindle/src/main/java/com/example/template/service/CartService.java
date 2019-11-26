package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;

    public void deleteById(Integer id){
        cartRepo.deleteById(id);
    }

    public Cart findAllByIduser(Integer id_user){
        return cartRepo.findAllById_user(id_user);
    }

    public List findAll(){
        return cartRepo.findAll();
    }

    public Cart save(Cart cart){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Cart cart1=new Cart(
                cart.getId_user(),
                cart.getId_product(),
                obDateFormat.format(obDate.getTime()).toString(),
                cart.getStatus(),
                cart.getTitle(),
                cart.getPict_product(),
                cart.getCategories(),
                cart.getPublication_year(),
                cart.getPrice(),
                cart.getAuthor(),
                cart.getPublisher(),
                cart.getIsbn()
        );

        return  cartRepo.save(cart1);
    }
//    public List findById_product(Integer idProduct){
//        return cartRepo.findAllById_product(idProduct);
//    }
    public Cart findFirstById(Integer id){
        return cartRepo.findFirstById(id);
    }
    public Cart findFirstByIdProduct(Integer idProduct){
        return cartRepo.findFirstById_product(idProduct);
    }
//    public List dat(){
//        return cartRepo.dat();
//    };
}
