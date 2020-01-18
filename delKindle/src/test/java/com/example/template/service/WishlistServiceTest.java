package com.example.template.service;

import com.example.template.model.Wishlist;
import com.example.template.repository.WishlistRepo;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class WishlistServiceTest {

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    Wishlist wishlist;
    @Mock
    WishlistRepo wishlistRepo;
    @InjectMocks
    WishlistService wishlistService;

    @Test
    public void testCheck(){
        wishlist.setSku_user("HEND-001");
        wishlist.setSku_product("HEND-0001-PROD-001");
        when(wishlistRepo.existsBySku_userAndSku_product(wishlist.getSku_user(),wishlist.getSku_product())).thenReturn(1);
        Integer expect=1;
        assertEquals(expect,wishlistService.check(wishlist.getSku_user(),wishlist.getSku_product()));
        Mockito.verify(wishlistRepo).existsBySku_userAndSku_product(wishlist.getSku_user(),wishlist.getSku_product());
    }

    @Test
    public void testFindAll(){
        List li=new ArrayList();
        Mockito.when(wishlistRepo.findAll()).thenReturn(li);
        assertEquals(li,wishlistService.findAll());
        Mockito.verify(wishlistRepo).findAll();
    }

    //belum bisa
    @Ignore
    @Test
    public void testSave(){
        Wishlist wis=new Wishlist();
        wis=wishlistRepo.save(wishlist);
        when(wishlistRepo.save(wishlist)).thenReturn(wis);
        when(wishlistService.save(wishlist)).thenReturn(wis);
        assertEquals(wis,wishlistService.save(wishlist));
        Mockito.verify(wishlistRepo).save(wishlist);
    }

    @Test
    public void testFindFirstById(){
                when(wishlist.getId()).thenReturn(1);
                when(wishlist.getCreated_at()).thenReturn("2019-11-12");
                when(wishlist.getStatus()).thenReturn(1);
                when(wishlist.getTitle()).thenReturn("title");
                when(wishlist.getPict_product()).thenReturn("pict.png");;
                when(wishlist.getCategories()).thenReturn("categories");;
                when(wishlist.getPublication_year()).thenReturn("2019");;
                when(wishlist.getPrice()).thenReturn(90000);;
                when(wishlist.getAuthor()).thenReturn("author");;
                when(wishlist.getPublisher()).thenReturn("publisher");;
                when(wishlist.getIsbn()).thenReturn("isbn-12387");;
                when(wishlist.getSku_user()).thenReturn("SkuUser");;
                when(wishlist.getSku_product()).thenReturn("skuProduct");
                Wishlist wishlist2=new Wishlist(
                        wishlist.getCreated_at(),
                        wishlist.getStatus(),
                        wishlist.getTitle(),
                        wishlist.getPict_product(),
                        wishlist.getCategories(),
                        wishlist.getPublication_year(),
                        wishlist.getPrice(),
                        wishlist.getAuthor(),
                        wishlist.getPublisher(),
                        wishlist.getIsbn(),
                        wishlist.getSku_user(),
                        wishlist.getSku_product()
                );
        Integer expect=1;
        assertEquals(expect,wishlist.getId());
        when(wishlistRepo.findFirstById(wishlist.getId())).thenReturn(wishlist2);
        assertEquals(wishlist2,wishlistService.findFirstById(wishlist.getId()));
        Mockito.verify(wishlistRepo).findFirstById(wishlist.getId());
    }

}