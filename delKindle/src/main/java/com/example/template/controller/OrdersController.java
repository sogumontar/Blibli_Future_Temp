package com.example.template.controller;

import com.example.template.model.Orders;
import com.example.template.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @CrossOrigin
    @PostMapping("/saveOrder")
    public Orders saveOrder(@RequestBody Orders orders){
        return ordersService.saveOrder(orders);
    }

    @CrossOrigin
    @GetMapping("/findLast")
    public Orders findLast(){
        return ordersService.findLast();
    }

    @CrossOrigin
    @GetMapping("/getAll")
    public List getAll(){
        return ordersService.getAll();
    }

    @CrossOrigin
    @GetMapping("/findBySkuUser/{skuUser}")
    public List findBySkuUser(@PathVariable String skuUser){
        return ordersService.findBySkuUser(skuUser);
    }

    @CrossOrigin
    @GetMapping("/findByVirtual/{virtual}")
    public List findByVirtual(@PathVariable String virtual){
        return ordersService.findByVirtual(virtual);
    }

    @CrossOrigin
    @GetMapping("/findById/{id}")
    public Optional<Orders> findById(@PathVariable Integer id){
        return  ordersService.findById(id);
    }

    @CrossOrigin
    @PostMapping("updateStatusAcc/{id}")
    public Orders updateStatusAcc(@PathVariable Integer id){
        return ordersService.updateStatusAcc(id);
    }
}
