package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.model.Wishlist;
import com.example.template.repository.WishlistRepo;
import com.example.template.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @Autowired
    WishlistRepo wishlistRepo;
    @CrossOrigin
    @GetMapping("/check/{skuUser}/{skuProduct}")
    public Integer check(@PathVariable  String skuUser, @PathVariable String skuProduct){

//        System.out.println(skuUser + skuProduct);
//        System.out.println(cartService.check(skuUser,skuProduct));
        return wishlistRepo.existsBySku_userAndSku_product(skuUser,skuProduct);
    }


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
//        Wishlist wishlist1=new Wishlist(
//                obDateFormat.format(obDate.getTime()).toString(),
//                wishlist.getStatus(),
//                wishlist.getTitle(),
//                wishlist.getPict_product(),
//                wishlist.getCategories(),
//                wishlist.getPublication_year(),
//                wishlist.getPrice(),
//                wishlist.getAuthor(),
//                wishlist.getPublisher(),
//                wishlist.getIsbn(),
//                wishlist.getSku_user(),
//                wishlist.getSku_product()
//        );
        return wishlistService.save(wishlist);
    }
    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deleteById(@PathVariable Integer id){
        wishlistService.delete(id);
        return "Success";
    }

    @CrossOrigin
    @GetMapping("existBySkuUser/{skuUser}")
    public Integer existBySkuUser(@PathVariable String skuUser){
        return  wishlistService.existBySku_user(skuUser);
    }

}
