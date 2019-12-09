package com.example.template.service;

import com.example.template.model.Orders;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrdersService ordersService;

    public String updateAfterCart(String sku_user){
        cartRepo.akhir(sku_user);
        return "sukses";
    }

    public Orders save(Orders orders){
        return orderRepo.save(orders);
    }

    public  Orders saveOrder(Orders orders){
        Orders orders1 = new Orders(
               orders.getSkuUser(),
               orders.getStatus(),
               orders.getCreatedAt(),
               orders.getVirtualaccount(),
               orders.getTipeTrans(),
               orders.getTotTrans()
        );
        return  ordersService.save(orders1);
    }

    public Orders findLast(){
        return orderRepo.findLast();
    }
}
