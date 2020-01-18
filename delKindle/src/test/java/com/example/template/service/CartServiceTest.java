package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.model.Orders;
import com.example.template.model.User;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Orders orders;
    @Mock
    OrderRepo orderRepo;
    @Mock
    private CartRepo cartRepo;
    @Mock
    private Cart cart;
    @Mock
    User user;
    @InjectMocks
    private CartService cartService;
    @Test
    public void testCheck(){
        Mockito.when(cartRepo.existsBySku_userAndSku_product("sku","skuProduct")).thenReturn(1);
        cartService.check("sku","skuProduct");
        Integer expected=1;
        assertEquals(expected, cartService.check("sku","skuProduct"));
        verify(cartRepo,times(2)).existsBySku_userAndSku_product("sku","skuProduct");
    }

    @Test
    public void testDeleteById(){
        Cart cart=new Cart();
        cart.setId(2);
        cartService.deleteById(2);
        Mockito.verify(cartRepo).deleteById(2);
    }

    @Test
    public void testFindAllBySku_user(){
//        cart.setId(1);
//        cart.setCreated_at("12-02-2019");
//        cart.setStatus(1);
//        cart.setTitle("judul");
//        cart.setPict_product("pict.png");
//        cart.setCategories("buku cerita");
//        cart.setPublication_year("2019");
//        cart.setPrice(90000);
//        cart.setAuthor("benyamin");
//        cart.setPublisher("benyamin2");
//        cart.setIsbn("123pkd213");
//        cart.setSku_user("HEND-0001");
//        cart.setSku_product("HEND-001-PROD-001");
//        cart.setSku_merchant("HEND-0001");
//        when(cart.getId()).thenReturn(1);
//        when(cart.getCreated_at()).thenReturn("12-02-2019");
//        when(cart.getStatus()).thenReturn(1);
//        when(cart.getTitle()).thenReturn("judul");
//        when(cart.getPict_product()).thenReturn("pict.png");
//        when(cart.getCategories()).thenReturn("buku cerita");
//        when(cart.getPublication_year()).thenReturn("2019");
//        when(cart.getPrice()).thenReturn(90000);
//        when(cart.getAuthor()).thenReturn("benyamin");
//        when(cart.getPublisher()).thenReturn("benyamin2");
//        when(cart.getIsbn()).thenReturn("123pkd213");
//        when(cart.getSku_user()).thenReturn("HEND-0001");
//        when(cart.getSku_product()).thenReturn("HEND-001-PROD-001");
//        when(cart.getSku_merchant()).thenReturn("HEND-0001");
        Cart cart1=new Cart( );
        Mockito.when(cartRepo.findAllBySku_user("HEND-0001")).thenReturn(cart1);
        assertEquals(cart1,cartService.findAllBySku_user("HEND-0001"));
        Mockito.verify(cartRepo).findAllBySku_user("HEND-0001");
    }

    @Test
    public void testFindAll(){
        List cart11=new ArrayList();
        cart11.add(cart.getCreated_at());
        cart11.add(cart.getStatus());
        cart11.add(cart.getTitle());
        cart11.add(cart.getPict_product());
        cart11.add(cart.getCategories());
        cart11.add(cart.getPublication_year());
        cart11.add(cart.getPrice());
        cart11.add(cart.getAuthor());
        cart11.add(cart.getPublisher());
        cart11.add(cart.getIsbn());
        cart11.add(cart.getSku_user());
        cart11.add(cart.getSku_product());
        cart11.add(cart.getSku_merchant());
        Mockito.when(cartRepo.findAll()).thenReturn(cart11);
        assertEquals(cart11,cartService.findAll());
        Mockito.verify(cartRepo).findAll();
    }

    @Test
    public void save(){
        Cart cart1=new Cart();
        Mockito.when(cartRepo.save(cart1)).thenReturn(cart);
        assertEquals(cart,cartRepo.save(cart1));
        Mockito.verify(cartRepo).save(cart1);
    }

    @Test
    public void testFindFirstById(){
        Cart cart1=new Cart();
        Mockito.when(cartRepo.findFirstById(1)).thenReturn(cart1);
        assertEquals(cart1,cartService.findFirstById(1));
        Mockito.verify(cartRepo).findFirstById(1);
    }


    @Test
    public void testFindFirstByIdProduct(){
        Cart cart1=new Cart();
        Mockito.when(cartRepo.findFirstBySku_product("HEND-0001")).thenReturn(cart1);
        assertEquals(cart1,cartService.findFirstByIdProduct("HEND-0001"));
        Mockito.verify(cartRepo).findFirstBySku_product("HEND-0001");
    }

    @Test
    public void testAllDate(){
        List cart11=new ArrayList();
        cart11.add(cart.getCreated_at());
        cart11.add(cart.getStatus());
        cart11.add(cart.getTitle());
        cart11.add(cart.getPict_product());
        cart11.add(cart.getCategories());
        cart11.add(cart.getPublication_year());
        cart11.add(cart.getPrice());
        cart11.add(cart.getAuthor());
        cart11.add(cart.getPublisher());
        cart11.add(cart.getIsbn());
        cart11.add(cart.getSku_user());
        cart11.add(cart.getSku_product());
        cart11.add(cart.getSku_merchant());
        Mockito.when(cartRepo.findAll()).thenReturn(cart11);
        assertEquals(cart11,cartService.allDate());
        Mockito.verify(cartRepo).findAll();
    }

    @Test
    public void testMakeOrder(){
        Orders orders=new Orders(

        );

//        when(cartRepo.save(orders)).thenReturn("sukses");
        when(cartService.makeOrder("ANDR-001","HEND-0001-PROD-001")).thenReturn("Sukses");
        assertEquals("Sukses",cartService.makeOrder("ANDR-001","HEND-0001-PROD-001"));
//        Mockito.verify(orderRepo).save(orders);
    }

    @Test
    public void testDeleteBySkuUser(){
        cart.setSku_user("HEND-0001");
        cartRepo.deleteBySku_user(cart.getSku_user());
        Mockito.verify(cartRepo).deleteBySku_user(cart.getSku_user());
    }
    @Test
    public void testUpdtBySkuUser(){
        cart.setSku_user("HEND-0002");
        cartRepo.updtBySkuUser(cart.getSku_user());
        Mockito.verify(cartRepo).updtBySkuUser(cart.getSku_user());
    }



}