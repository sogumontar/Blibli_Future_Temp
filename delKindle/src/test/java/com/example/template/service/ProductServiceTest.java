package com.example.template.service;

import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
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

@Ignore
public class ProductServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    ProductRepo productRepo;
    @Mock
    Product product;
    @InjectMocks
    ProductService productService;

    @Test
    public void testFindAll(){
        List list=new ArrayList();
        product=new Product(

        );
        Mockito.when(productRepo.findAll()).thenReturn(list);
        assertEquals(list,productService.findAll());
        Mockito.verify(productRepo).findAll();
    }

    @Test
    public void testFindFirstBySku(){
        Mockito.when(product.getSku_product()).thenReturn("SKU_PRODUCT");
        String expect="SKU_PRODUCT";
        assertEquals(expect,product.getSku_product());
        Mockito.when(productRepo.findFirstBySku_product(product.getSku_product())).thenReturn(product);
        assertEquals(product,productService.findFirstBySku(product.getSku_product()));
//        Mockito.verify(productRepo).deleteBySku_product(product.getSku_product());
    }
    @Test
    public void testSave(){
        product=new Product();
        Mockito.when(productRepo.save(product)).thenReturn(product);
        assertEquals(product,productService.save(product));
        Mockito.verify(productRepo).save(product);
    }
    @Test
    public void testFindAllByCategories(){
        Mockito.when(product.getCategories()).thenReturn("Kategori");
        String expect="Kategori";
        assertEquals(expect,product.getCategories());
        List list = new ArrayList();
        Mockito.when(productRepo.findAllByCategories(product.getCategories())).thenReturn(list);
        assertEquals(list,productService.findAllByCategories(product.getCategories()));
        Mockito.verify(productRepo).findAllByCategories(product.getCategories());
    }
    @Test
    public void testDeleteBySkuProduct(){
        Mockito.when(product.getSku_product()).thenReturn("SKU_PRODUCT");
        String expect="SKU_PRODUCT";
        assertEquals(expect,product.getSku_product());
//        Mockito.verify(productRepo).deleteBySku_product("SKU_PRODUCT");
    }
    @Test
    public void testFindAllBySkuMerchant(){
        Mockito.when(product.getSku_merchant()).thenReturn("SKU_MERCHANT");
        String expect="SKU_MERCHANT";
        assertEquals(expect,product.getSku_merchant());
        List list = new ArrayList();
        Mockito.when(productRepo.findAllBySku_merchant(product.getSku_merchant())).thenReturn(list);
        assertEquals(list,productService.findAllBySkuMerchant(product.getSku_merchant()));
        Mockito.verify(productRepo).findAllBySku_merchant(product.getSku_merchant());
    }


}