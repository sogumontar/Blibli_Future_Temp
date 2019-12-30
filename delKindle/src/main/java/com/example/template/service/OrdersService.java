package com.example.template.service;

import com.example.template.model.Orders;
import com.example.template.repository.CartRepo;
import com.example.template.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
               orders.getTotTrans(),
                orders.getName()
        );
        return  ordersService.save(orders1);
    }

    public Orders findLast(){
        return orderRepo.findLast();
    }

    public List getAll(){
        return orderRepo.getAll();
    }

    public List findBySkuUser(String skuUser){
        return orderRepo.findBySkuUser(skuUser);
    }

    public List findByVirtual(String virtual){
        return orderRepo.findByVirtualaccount(virtual);
    }

    public Optional<Orders> findById(Integer id){
        return orderRepo.findById(id);
    }

    public Orders updateStatusAcc(Integer id){
        Orders orders = orderRepo.findFirstById(id);
        orders.setStatus(2);
        return ordersService.save(orders);
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
