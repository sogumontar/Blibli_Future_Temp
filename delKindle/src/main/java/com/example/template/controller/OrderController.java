package com.example.template.controller;

import com.example.template.model.Order;
import com.example.template.repository.OrderRepo;
import com.example.template.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class OrderController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderService orderService;
    @GetMapping("/")
    public List findAll(){
        return orderRepo.findAll();
    }
    @PostMapping("/add")
    public String add(Order order){
        Order order1=new Order(
                order.getId(),
                order.getIdUser(),
                order.getIdProduct(),
                order.getDate(),
                order.getStatus()
        );
        orderService.add(order1);
        return "sukses";
    }
}
