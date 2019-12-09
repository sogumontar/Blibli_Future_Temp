package com.example.template.services.controllers.impl;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
import com.example.template.service.ProductService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class ProductServiceImplTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepo productRepo;

    @Before
    public void setup(){this.productService=new ProductService();}
    @Test
    public void testFindFirstBySku_product() {
        Product product = new Product();
        product.setSku_product("HEND-0003-0003");
        product.setAuthor("Hendra");
        when(this.productRepo.findFirstBySku_product("HEND-0003-0003")).thenReturn(product);

        Product result = productService.findFirstBySku("HEND-0003-0003");
        assertNotNull(result);

        String id = result.getSku_product();
        String author= result.getAuthor();
        assertEquals("HEND-0003-0003", id);
        assertEquals("Hendra", author);
    }


}
