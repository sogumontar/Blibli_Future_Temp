package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import com.example.template.service.CartService;
import com.example.template.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CartService cartService;
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrdersService ordersService;
    @Autowired
    CartRepo cartRepo;

    @CrossOrigin
    @GetMapping("/check/{skuUser}/{skuProduct}")
    public Integer check(@PathVariable  String skuUser, @PathVariable String skuProduct){
        return cartRepo.existsBySku_userAndSku_product(skuUser,skuProduct);
    }


    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return cartService.findAll();
    }
//    @CrossOrigin
//    @GetMapping("/finds")
//    public List findAllById_product(@PathVariable  Integer productId){
//        return cartService.dat();
//    }

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
        return cartService.save(cart);
    }

    @Transactional
    @CrossOrigin
    @PutMapping("/purchase/{skuUser}")
    public ResponseEntity<Object> purchase( @PathVariable String skuUser){
//        Optional<Cart> cartOptional=Optional.ofNullable(cartService.findFirstById(idLogin));
//        if(!cartOptional.isPresent())
//            return ResponseEntity.notFound().build();
            cartRepo.updateAll(skuUser);
            return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @Transactional
    public String deleteById(@PathVariable Integer id){
         cartService.deleteById(id);
         return "Success";
    }

    @CrossOrigin
    @PostMapping("/final/{skuUser}/{skuProducts}")
    public void akhir(@PathVariable String skuUser, @PathVariable String skuProducts){
        cartService.makeOrder(skuUser,skuProducts);
    }

    @CrossOrigin
    @PutMapping("/finish/{sku_user}")
    public String akhirskall(@PathVariable String sku_user){
        ordersService.updateAfterCart(sku_user);
        System.out.println(ordersService.updateAfterCart(sku_user));
        return "Sukses";
    }

    @Transactional
    @CrossOrigin
    @DeleteMapping("/checkout/{sku_user}")
    public String checkout(@PathVariable String sku_user){
        cartService.checkout(sku_user);
        return "success";
    }

    @CrossOrigin
    @Transactional
    @DeleteMapping("/delBySkuUser/{sku_user}")
    public String delBySkuUser(@PathVariable String sku_user){
        cartService.deleteBySkuUser(sku_user);
        return "Delete Success";
    }

    @CrossOrigin
    @Transactional
    @PutMapping("updtBySkuUser/{sku_user}")
    public String updtBySkuUser(@PathVariable String sku_user){
        cartService.updtBySkuUser(sku_user);
        return "Updated Success";
    }

}
