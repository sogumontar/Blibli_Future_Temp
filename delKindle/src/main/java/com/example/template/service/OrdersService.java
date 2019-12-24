package com.example.template.service;

import com.example.template.model.Orders;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    CartRepo cartRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrdersService ordersService;

    public List updateAfterCart(String sku_user){
        return cartRepo.akhir(sku_user);

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
               orders.getTotTrans(),
               orders.getSku_product()
        );
        System.out.println(orders.getSku_product());
        return  ordersService.save(orders1);
    }

    public Orders findLast(){
        return orderRepo.findLast();
    }
    public List findAllBySkuAndStatus(String sku, Integer status){
        return orderRepo.findAllBySkuUserAndStatus(sku,status);
    }
    public void deleteById(Integer id){
        orderRepo.deleteById(id);
    }

    //findVirtualAccount
    public Orders findVirtualAccount(int id){
        return orderRepo.findById(id);
    }

    public String updateById(Integer id ){
        orderRepo.updateOrdersById(id);
        return "Success update";
    }
}
