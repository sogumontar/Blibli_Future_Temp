package com.example.template.service;

import com.example.template.model.DetailOrder;
import com.example.template.repository.DetailOrderRepository;
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

public class DetailOrderServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Mock
    DetailOrderRepository detailOrderRepository;

    @Mock
    DetailOrder detailOrder;
    @InjectMocks
    DetailOrderService detailOrderService;

    @Test
    public void testSave(){
        Mockito.when(detailOrderRepository.save(detailOrder)).thenReturn(detailOrder);
        assertEquals(detailOrder,detailOrderService.save(detailOrder));
        Mockito.verify(detailOrderRepository).save(detailOrder);
    }

//    @Test
//    public void testSaveDetailOrder(){
//        Mockito.when(detailOrderRepository.save(detailOrder)).thenReturn(detailOrder);
//        Mockito.when(detailOrderService.saveDetailOrder(detailOrder)).thenReturn(detailOrder);
////        assertEquals(detailOrder,detailOrderService.saveDetailOrder(detailOrder));
//        Mockito.verify(detailOrderService).save(detailOrder);
//    }


    @Test
    public void testFindBySkuMerchant(){
        List list=new ArrayList();
        Mockito.when(detailOrder.getSku_product()).thenReturn("SKU_PRODUCT");
        Mockito.when(detailOrder.getSku_merchant()).thenReturn("SKU_Merchant");
        Mockito.when(detailOrder.getIdOrder()).thenReturn(1);
        Mockito.when(detailOrder.getTitle()).thenReturn("TITLE");
        Mockito.when(detailOrder.getPict_product()).thenReturn("PICT.png");
        Mockito.when(detailOrder.getCategories()).thenReturn("CATEGORIES");
        Mockito.when(detailOrder.getPublication_year()).thenReturn("2019");
        Mockito.when(detailOrder.getPrice()).thenReturn(80000);
        Mockito.when(detailOrder.getAuthor()).thenReturn("Benyamin");
        Mockito.when(detailOrder.getPublisher()).thenReturn("laccazette");
        Mockito.when(detailOrder.getIsbn()).thenReturn("12398asdkjh");
        Mockito.when(detailOrder.getStatus()).thenReturn(1);
        Mockito.when(detailOrder.getSku_user()).thenReturn("SKU_USER");

        assertEquals("SKU_PRODUCT",detailOrder.getSku_product());
        assertEquals("SKU_Merchant",detailOrder.getSku_merchant());
        assertEquals((Integer)1,detailOrder.getIdOrder());
        assertEquals("TITLE",detailOrder.getTitle());
        assertEquals("PICT.png",detailOrder.getPict_product());
        assertEquals("CATEGORIES",detailOrder.getCategories());
        assertEquals("2019",detailOrder.getPublication_year());
        assertEquals((Integer)80000,detailOrder.getPrice());
        assertEquals("Benyamin",detailOrder.getAuthor());
        assertEquals("laccazette",detailOrder.getPublisher());
        assertEquals("12398asdkjh",detailOrder.getIsbn());
        assertEquals((Integer)1,detailOrder.getStatus());
        assertEquals("SKU_USER",detailOrder.getSku_user());
        list.add(detailOrder.getSku_product());
        list.add(detailOrder.getSku_merchant());
        list.add(detailOrder.getIdOrder());
        list.add(detailOrder.getTitle());
        list.add(detailOrder.getPict_product());
        list.add(detailOrder.getCategories());
        list.add(detailOrder.getPublication_year());
        list.add(detailOrder.getPrice());
        list.add(detailOrder.getAuthor());
        list.add(detailOrder.getPublisher());
        list.add(detailOrder.getIsbn());
        list.add(detailOrder.getStatus());
        list.add(detailOrder.getSku_user());

        Mockito.when(detailOrderRepository.findBySkuMerchant(detailOrder.getSku_merchant())).thenReturn(list);
        assertEquals(list,detailOrderService.findBySkuMerchant(detailOrder.getSku_merchant()));
        Mockito.verify(detailOrderRepository).findBySkuMerchant(detailOrder.getSku_merchant());
    }
    @Test
    public void testFindAll(){
        List list=new ArrayList();
        Mockito.when(detailOrder.getSku_product()).thenReturn("SKU_PRODUCT");
        Mockito.when(detailOrder.getSku_merchant()).thenReturn("SKU_Merchant");
        Mockito.when(detailOrder.getIdOrder()).thenReturn(1);
        Mockito.when(detailOrder.getTitle()).thenReturn("TITLE");
        Mockito.when(detailOrder.getPict_product()).thenReturn("PICT.png");
        Mockito.when(detailOrder.getCategories()).thenReturn("CATEGORIES");
        Mockito.when(detailOrder.getPublication_year()).thenReturn("2019");
        Mockito.when(detailOrder.getPrice()).thenReturn(80000);
        Mockito.when(detailOrder.getAuthor()).thenReturn("Benyamin");
        Mockito.when(detailOrder.getPublisher()).thenReturn("laccazette");
        Mockito.when(detailOrder.getIsbn()).thenReturn("12398asdkjh");
        Mockito.when(detailOrder.getStatus()).thenReturn(1);
        Mockito.when(detailOrder.getSku_user()).thenReturn("SKU_USER");

        assertEquals("SKU_PRODUCT",detailOrder.getSku_product());
        assertEquals("SKU_Merchant",detailOrder.getSku_merchant());
        assertEquals((Integer)1,detailOrder.getIdOrder());
        assertEquals("TITLE",detailOrder.getTitle());
        assertEquals("PICT.png",detailOrder.getPict_product());
        assertEquals("CATEGORIES",detailOrder.getCategories());
        assertEquals("2019",detailOrder.getPublication_year());
        assertEquals((Integer)80000,detailOrder.getPrice());
        assertEquals("Benyamin",detailOrder.getAuthor());
        assertEquals("laccazette",detailOrder.getPublisher());
        assertEquals("12398asdkjh",detailOrder.getIsbn());
        assertEquals((Integer)1,detailOrder.getStatus());
        assertEquals("SKU_USER",detailOrder.getSku_user());
        list.add(detailOrder.getSku_product());
        list.add(detailOrder.getSku_merchant());
        list.add(detailOrder.getIdOrder());
        list.add(detailOrder.getTitle());
        list.add(detailOrder.getPict_product());
        list.add(detailOrder.getCategories());
        list.add(detailOrder.getPublication_year());
        list.add(detailOrder.getPrice());
        list.add(detailOrder.getAuthor());
        list.add(detailOrder.getPublisher());
        list.add(detailOrder.getIsbn());
        list.add(detailOrder.getStatus());
        list.add(detailOrder.getSku_user());

        Mockito.when(detailOrderRepository.findAll()).thenReturn(list);
        assertEquals(list,detailOrderService.findAll());
        Mockito.verify(detailOrderRepository).findAll();

    }

    @Test
    public void testDeleteByDetailOrderId(){
        Mockito.when(detailOrder.getId()).thenReturn(1);
        assertEquals((Integer)1,detailOrder.getId());
        Mockito.verify(detailOrderRepository).deleteByOrderId(1);
    }

    @Test
    public void testUpdateByIdOrder(){
        Mockito.when(detailOrder.getId()).thenReturn(1);
        assertEquals((Integer)1,detailOrder.getId());

        assertEquals("Success Update",detailOrderService.updateByIdOrder(detailOrder.getId()));
        Mockito.verify(detailOrderRepository).updateByIdOrder(detailOrder.getId());
    }
    @Test
    public void testFindLibrary(){
        Mockito.when(detailOrder.getSku_user()).thenReturn("SKU_USER");
        assertEquals("SKU_USER",detailOrder.getSku_user());
        List list = new ArrayList();
        Mockito.when(detailOrderRepository.findLibrary(detailOrder.getSku_user())).thenReturn(list);
        assertEquals(list,detailOrderService.findLibrary(detailOrder.getSku_user()));
        Mockito.verify(detailOrderRepository).findLibrary(detailOrder.getSku_user());
    }
}