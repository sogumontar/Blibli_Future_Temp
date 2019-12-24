package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.model.Orders;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    OrderRepo orderRepo;
    public Integer check(String skuUser,String skuProduct){
        return cartRepo.existsBySku_userAndSku_product(skuUser,skuProduct);
    }

    public void deleteById(Integer id){
        cartRepo.deleteById(id);
    }

    public Cart findAllBySku_user(String sku_user){
        return cartRepo.findAllBySku_user(sku_user);
    }

    public List findAll(){
        return cartRepo.findAll();
    }

    public Cart save(Cart cart){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Cart cart1=new Cart(
                obDateFormat.format(obDate.getTime()).toString(),
                cart.getStatus(),
                cart.getTitle(),
                cart.getPict_product(),
                cart.getCategories(),
                cart.getPublication_year(),
                cart.getPrice(),
                cart.getAuthor(),
                cart.getPublisher(),
                cart.getIsbn(),
                cart.getSku_user(),
                cart.getSku_product(),
                cart.getSku_merchant()
        );

        return  cartRepo.save(cart1);
    }
    //    public List findById_product(Integer idProduct){
//        return cartRepo.findAllById_product(idProduct);
//    }
    public Cart findFirstById(Integer id){
        return cartRepo.findFirstById(id);
    }
    public Cart findFirstByIdProduct(String idProduct){
        return cartRepo.findFirstBySku_product(idProduct);
    }
//    public List dat(){
//        return cartRepo.dat();
//    };
//    public Cart addToOrder(Cart cart){
//        Date obDate = new Date();
//        SimpleDateFormat obDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println("Current Date of system :"
//                + obDateFormat.format(obDate.getTime()));
//        String waktuSekarang=obDateFormat.format(obDate.getTime());
//        Cart cart1=new Order(
//                cart.getId_user(),
//                cart.getId_product(),
//                waktuSekarang,
//                1
//        );
//        return cartRepo.addToOrder(cart1);
//    }

    public List allDate(){
        return cartRepo.findAll();
    }

    public String makeOrder(String skuUser,String skuProducts){
        Date obDate = new Date();
        SimpleDateFormat obDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Orders orders=new Orders(
                skuUser,
                skuProducts,
                1,
                obDateFormat.format(obDate.getTime()).toString()
        );
        orderRepo.save(orders);
        return "Sukses";
    }

    public String checkout(String sku_user){
        cartRepo.checkout(sku_user);
        return "success";
    }
}
