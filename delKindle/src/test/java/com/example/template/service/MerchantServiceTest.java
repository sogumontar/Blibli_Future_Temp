package com.example.template.service;

import com.example.template.model.Product;
import com.example.template.payload.CatalogEntryRequest;
import com.example.template.repository.MerchantRepository;
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

public class MerchantServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Mock
    CatalogEntryRequest catalogEntryRequest;
    @Mock
    Product product;
    @Mock
    MerchantRepository merchantRepository;

    @Mock
    LastProductService lastProductService;

    @Mock
    SeqProductService seqProductService;
    @InjectMocks
    MerchantService merchantService;


    @Test
    public void testSave(){
        Product product1=new Product();
        Mockito.when(merchantRepository.save(product)).thenReturn(product1);
        assertEquals(product1,merchantService.save(product));
        Mockito.verify(merchantRepository).save(product);
    }
    @Test
    public void testFindBySkuMerchant(){
        List list=new ArrayList();
        Mockito.when(product.getSku_merchant()).thenReturn("SKU_MERCHANT");
        assertEquals("SKU_MERCHANT",product.getSku_merchant());
        Mockito.when(merchantRepository.findBySku_merchant(product.getSku_merchant())).thenReturn(list);
        assertEquals(list,merchantService.findBySkuMerchant(product.getSku_merchant()));
        Mockito.verify(merchantRepository).findBySku_merchant(product.getSku_merchant());
    }

    @Test
    public void testCountByIdMerchant(){
        Mockito.when(product.getSku_merchant()).thenReturn("SKU_MERCHANT");
        assertEquals("SKU_MERCHANT",product.getSku_merchant());
        Mockito.when(merchantRepository.countById_merchant(product.getSku_merchant())).thenReturn(3);
        assertEquals((Integer)3,merchantService.countByIdMerchant(product.getSku_merchant()));
        Mockito.verify(merchantRepository).countById_merchant(product.getSku_merchant());
    }

//    @Test
//    public void testAddProduct(){
//        Mockito.verify(lastProductService).findLast().getLast_book();
//    }

//    @Test
//    public void testUpdateProduct(){
//        Mockito.verify(lastProductService.findLast().getLast_book());
//    }

//    @Test
//    public void testUnescapeUntilNoHtmlEntityFound(){
////        Mockito.when(merchantService).unescapeUntilNoHtmlEntityFound;
//    }

//    @Ignore
//    @Test
//    public void testSaveProduct(){
////        Mockito.when(merchantService.saveProduct(catalogEntryRequest)).thenReturn("Sukses");
////        assertEquals("Sukses",merchantService.saveProduct(catalogEntryRequest));
//        Mockito.verify(merchantService).save(product);
//    }
}