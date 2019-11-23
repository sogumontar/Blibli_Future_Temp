package com.example.template.services.controllers.impl;

import com.example.template.model.Product;
import com.example.template.service.ProductService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductServiceImplTests {
private ProductService productService;

    @Test
    public void testFindFirstById(){
        Product result=productService.findFirstById(21);
        String id=result.getId().toString();
        assertEquals("tt",id);
        assertEquals("tt",result.getDescription());
        assertEquals("Buku Anak anak",result.getCategories());
        assertEquals("123",result.getPublication_year());
        assertEquals("4213",result.getPrice());
        assertEquals("dol",result.getPublisher());
        assertEquals("12344",result.getIsbn());
        assertEquals("1a.png",result.getPict_product());
    }


}
