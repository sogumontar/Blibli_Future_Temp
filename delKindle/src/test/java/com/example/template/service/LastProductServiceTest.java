package com.example.template.service;

import com.example.template.model.LastProduct;
import com.example.template.repository.LastProductRepository;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class LastProductServiceTest {
    @Rule
    public MockitoRule rule= MockitoJUnit.rule();

    @Mock
    LastProductRepository lastProductRepository;
    @Mock
    LastProduct lastProduct;
    @InjectMocks
    LastProductService lastProductService;

    @Test
    public void testFindLast(){
        lastProduct=new LastProduct();
        Mockito.when(lastProductRepository.findLast()).thenReturn(lastProduct);
        assertEquals(lastProduct,lastProductService.findLast());
        Mockito.verify(lastProductRepository).findLast();
    }
    @Test
    public void testSave(){
//        Mockito.verify(lastProduct).setLast_book(1);
//        Mockito.verify(lastProduct).setLast_picture(2);
        Mockito.when(lastProductRepository.save(lastProduct)).thenReturn(lastProduct);
        assertEquals(lastProduct,lastProductRepository.save(lastProduct));
        Mockito.verify(lastProductRepository).save(lastProduct);
    }
}