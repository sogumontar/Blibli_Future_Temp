package com.example.template.services.controllers.impl;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
import com.example.template.service.ProductService;
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

    @Test
    public void testFindFirstById() {
        Product product = new Product();
        product.setSku_product("21");
        when(productRepo.findFirstBySku_product("21")).thenReturn(product);

        Product result = productService.findFirstBySku("21");
        assertNotNull(result);

        String id = result.getSku_product();
        assertEquals("21", id);
    }


}
