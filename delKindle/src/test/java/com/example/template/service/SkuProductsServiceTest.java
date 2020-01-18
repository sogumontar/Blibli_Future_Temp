package com.example.template.service;

import com.example.template.model.SkuProducts;
import com.example.template.repository.SkuProductsRepo;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.*;

public class SkuProductsServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    SkuProducts skuProducts;
    @Mock
    SkuProductsRepo skuProductsRepo;
    @InjectMocks
    SkuProductsService skuProductsService;

    @Test
    public void testFindByKey(){
        Mockito.when(skuProducts.getKey()).thenReturn("test");
        Mockito.when(skuProducts.getId()).thenReturn("1");
        Mockito.when(skuProducts.getLast_key()).thenReturn("LastKey");
        Mockito.when(skuProducts.isStatus()).thenReturn(TRUE);
        String expect="key";
        assertEquals(expect,"key");
        skuProducts=new SkuProducts(
                skuProducts.getId(),
                skuProducts.getKey(),
                skuProducts.getLast_key(),
                skuProducts.isStatus()
        );
        Mockito.when(skuProductsRepo.findByKey(skuProducts.getKey())).thenReturn(skuProducts);
        assertEquals(skuProducts,skuProductsService.findByKey(skuProducts.getKey()));
        Mockito.verify(skuProductsRepo).findByKey(skuProducts.getKey());
    }

    @Test
    public void testExistsByKey(){
        Mockito.when(skuProducts.getKey()).thenReturn("KEY_product");
        Mockito.when(skuProductsRepo.existsByKey(skuProducts.getKey())).thenReturn(TRUE);
        assertEquals(TRUE,skuProductsService.existsByKey(skuProducts.getKey()));
//        Mockito.verify(skuProductsRepo.existsByKey(skuProducts.getKey()));
    }
    
}