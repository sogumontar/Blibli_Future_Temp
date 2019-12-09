package com.example.template.controller;

import com.example.template.model.Orders;
import com.example.template.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
