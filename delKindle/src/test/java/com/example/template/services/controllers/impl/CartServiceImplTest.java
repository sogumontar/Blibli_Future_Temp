package com.example.template.services.controllers.impl;

import com.example.template.model.Cart;
import com.example.template.service.CartService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class CartServiceImplTest {
    private CartService cartService;
    @Before
    public void setup(){
        this.cartService=new CartService();
    }
    @Test
    public void testCheck(){
        Cart cart=new Cart();
        Integer check=0;
        when(cartService.check("HEND-0003-0003","HEND-0003")).thenReturn(check);
        assertEquals("0",check);
    }
}
