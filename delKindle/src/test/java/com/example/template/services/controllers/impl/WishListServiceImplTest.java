package com.example.template.services.controllers.impl;

import com.example.template.model.Wishlist;
import com.example.template.repository.WishlistRepo;
import com.example.template.service.WishlistService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class WishListServiceImplTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private WishlistRepo wishlistRepo;
    @Mock
    private WishlistService wishlistService;
    @InjectMocks
    private Wishlist wishlist;
    @Test
    public void testCheck(){
        Wishlist wishlist=new Wishlist();
        wishlist.setSku_product("skuProduct");
        wishlist.setSku_user("sku");
        Mockito.when(wishlistRepo.existsBySku_userAndSku_product("sku","skuProduct")).thenReturn(1);

        Integer actual=wishlistService.check("sku","skuProduct");
        Integer expected=1;
        assertEquals(expected, actual);
    }
}
