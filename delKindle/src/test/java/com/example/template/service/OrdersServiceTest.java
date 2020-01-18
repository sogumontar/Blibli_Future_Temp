package com.example.template.service;

import com.example.template.model.Cart;
import com.example.template.model.Orders;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
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
public class OrdersServiceTest {

    @Rule
    public MockitoRule rule= MockitoJUnit.rule();
    @Mock
    Cart cart;
    @Mock
    Orders orders;
    @Mock
    CartRepo cartRepo;
    @Mock
    OrderRepo orderRepo;
    @InjectMocks
    OrdersService ordersService;

    @Test
    public void testUpdateAfterCart(){
        Mockito.when(cart.getSku_user()).thenReturn("SKU_USER");
        assertEquals("SKU_USER",cart.getSku_user());
        List list=new ArrayList();
        Mockito.when(cartRepo.akhir(cart.getSku_user())).thenReturn(list);
        assertEquals(list,ordersService.updateAfterCart(cart.getSku_user()));
        Mockito.verify(cartRepo).akhir(cart.getSku_user());
    }
    @Test
    public void testSave(){
        Mockito.when(orders.getSkuUser()).thenReturn("SKU_USER");
        Mockito.when(orders.getStatus()).thenReturn(1);
        Mockito.when(orders.getCreatedAt()).thenReturn("SKU_USER");
        Mockito.when(orders.getVirtualaccount()).thenReturn("SKU_USER");
        Mockito.when(orders.getTipeTrans()).thenReturn(3);
        Mockito.when(orders.getTotTrans()).thenReturn(900000);
//        Mockito.when(orders.getSku_product()).thenReturn("SKU_USER");
        orders =new Orders(
                orders.getSkuUser(),
                orders.getStatus(),
                orders.getCreatedAt(),
                orders.getVirtualaccount(),
                orders.getTipeTrans(),
                orders.getTotTrans(),
                orders.getSku_product()
        );
        Mockito.when(orderRepo.save(orders)).thenReturn(orders);
        assertEquals(orders,ordersService.save(orders));
        Mockito.verify(orderRepo).save(orders);
    }

    @Ignore
    @Test
    public void testSaveOrder(){
        Mockito.when(orderRepo.save(orders)).thenReturn(orders);
        assertEquals(orders,ordersService.save(orders));
        Mockito.verify(orderRepo).save(orders);
    }
    @Test
    public void testFindLast(){
        Mockito.when(orders.getSkuUser()).thenReturn("SKU_USER");
        Mockito.when(orders.getStatus()).thenReturn(1);
        Mockito.when(orders.getCreatedAt()).thenReturn("2019-12-02");
        Mockito.when(orders.getVirtualaccount()).thenReturn("kajsd-cmsk");
        Mockito.when(orders.getTipeTrans()).thenReturn(3);
        Mockito.when(orders.getTotTrans()).thenReturn(900000);
        Mockito.when(orders.getSku_product()).thenReturn("SKU_PRODUCT");

        assertEquals("SKU_USER",orders.getSkuUser());
        assertEquals((Integer)1,orders.getStatus());
        assertEquals("2019-12-02",orders.getCreatedAt());
        assertEquals("kajsd-cmsk",orders.getVirtualaccount());
        assertEquals((Integer)3,orders.getTipeTrans());
        assertEquals((Integer)900000,orders.getTotTrans());
        assertEquals("SKU_PRODUCT",orders.getSku_product());

        orders =new Orders(
                orders.getSkuUser(),
                orders.getStatus(),
                orders.getCreatedAt(),
                orders.getVirtualaccount(),
                orders.getTipeTrans(),
                orders.getTotTrans(),
                orders.getSku_product()
        );
        Mockito.when(orderRepo.findLast()).thenReturn(orders);
        assertEquals(orders,ordersService.findLast());
    }

    @Test
    public void testFindAllBySkuAndStatus(){
        List list=new ArrayList();
        list.add(orders.getSkuUser());
        list.add(orders.getStatus());
        list.add(orders.getCreatedAt());
        list.add(orders.getVirtualaccount());
        list.add(orders.getTipeTrans());
        list.add(orders.getTotTrans());
        list.add(orders.getSku_product());

        Mockito.when(orders.getSkuUser()).thenReturn("SKU_USER");
        Mockito.when(orders.getStatus()).thenReturn(1);
        Mockito.when(orders.getCreatedAt()).thenReturn("2019-12-02");
        Mockito.when(orders.getVirtualaccount()).thenReturn("kajsd-cmsk");
        Mockito.when(orders.getTipeTrans()).thenReturn(3);
        Mockito.when(orders.getTotTrans()).thenReturn(900000);
        Mockito.when(orders.getSku_product()).thenReturn("SKU_PRODUCT");


        assertEquals("SKU_USER",orders.getSkuUser());
        assertEquals((Integer)1,orders.getStatus());
        assertEquals("2019-12-02",orders.getCreatedAt());
        assertEquals("kajsd-cmsk",orders.getVirtualaccount());
        assertEquals((Integer)3,orders.getTipeTrans());
        assertEquals((Integer)900000,orders.getTotTrans());
        assertEquals("SKU_PRODUCT",orders.getSku_product());


        Mockito.when(orderRepo.findAllBySkuUserAndStatus(orders.getSkuUser(),orders.getStatus())).thenReturn(list);
        assertEquals(list,ordersService.findAllBySkuAndStatus(orders.getSkuUser(),orders.getStatus()));
        Mockito.verify(orderRepo).findAllBySkuUserAndStatus(orders.getSkuUser(),orders.getStatus());
    }
    @Test
    public void testDeleteById(){
        Mockito.when(orders.getId()).thenReturn(1);
        assertEquals((Integer)1,orders.getId());

//        Mockito.verify(orderRepo).deleteById(orders.getId());

    }
    @Test
    public void testFindVirtualAccount(){

        Mockito.when(orders.getId()).thenReturn(1);
        assertEquals((Integer)1,orders.getId());
        Mockito.when(ordersService.findVirtualAccount(orders.getId())).thenReturn(orders);
        assertEquals(orders,ordersService.findVirtualAccount(orders.getId()));
    }



}