package com.example.template.service.impl;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import com.example.template.repository.CartRepo;
import com.example.template.repository.ProductRepo;
import com.example.template.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl {
//
//    @Autowired
//    private CartRepo cartRepo;
//
//    @Autowired
//    private OrderRepo orderRepo;
//
//    @Autowired
//    private ProductRepo productRepo;
//
//    @Override
//    public boolean purchase(String customerId) {
//        List<Cart> cartList = cartRepo.findAllById_user(
//                customerId);
//
//        Order order = proceedToOrder(cartList);
//        return false;
//    }
//
//    private Order proceedToOrder(List<Cart> cartList){
//        Order order = new Order();
//        long totalAmount = 0L;
//        for (Cart cart : cartList){
//            int idProd = cart.getId_product();
//            Product product = productRepo.getOne(idProd);
//            totalAmount += product.getPrice() * cart.getQuantity();
//        }
//        order.setTotalAmount(totalAmount)
//    }
}
