package com.example.template.controller;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.CartRepo;
import com.example.template.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.Option;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CartService cartService;

    @Autowired
    CartRepo cartRepo;

    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return cartService.findAll();
    }
    @CrossOrigin
    @GetMapping("/finds/{productId}")
    public Cart findAllById_product(@PathVariable  Integer productId){
        return cartService.findFirstByIdProduct(productId);
    }

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

    @CrossOrigin
    @GetMapping("/exist/{idUser}/{idProduct}")
    public Long existByIdUserAndIdProduct(@PathVariable Long idUser,@PathVariable Integer idProduct){
        System.out.println(cartRepo.existsById_userAndId_product(idUser,idProduct));
        //         cartService.existsById_userAndId_product((long)idUser,idProduct);
//         Optional<Cart> idUserCheck= Optional.ofNullable(cartService.findFirstById(idUser));
//         Optional<Cart> idProductCheck= Optional.ofNullable(cartService.findFirstByIdProduct(idProduct));
//         System.out.println(cartService.existsById_userAndId_product((long)idUser,idProduct));
//         System.out.println(cartService.findFirstByIdProduct(idProduct));
//         if(cartRepo.existsById_userAndId_product(idUser,idProduct)==0){
//             return ResponseEntity.noContent().build();
//         }
         return cartRepo.existsById_userAndId_product(idUser,idProduct);
    }

    @CrossOrigin
    @PostMapping("/purchase/{idLogin}")
    public ResponseEntity<Object> purchase(@RequestBody Cart cart, @PathVariable Integer idLogin){
        Optional<Cart> cartOptional=Optional.ofNullable(cartService.findFirstById(idLogin));
        if(!cartOptional.isPresent())
            return ResponseEntity.notFound().build();

            cart.setId(idLogin);
            cart.setStatus(2);
            Cart cart1=new Cart(2);
            cartService.save(cart);
            return ResponseEntity.ok().build();


    }

    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void deleteById(@PathVariable Integer id){
        cartService.deleteById(id);
    }

    @CrossOrigin
    @GetMapping("/order/{id}")
    public Cart findAllByIdUser(Integer id){
        System.out.println(cartService.findAllByIduser(id));
        return cartService.findAllByIduser(id);
    }

}
