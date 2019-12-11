package com.example.template.controller;

import com.example.template.model.DetailOrder;
import com.example.template.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("detailOrder")
public class DetailOrderController {

    @Autowired
    DetailOrderService detailOrderService;

    @CrossOrigin
    @PostMapping("/saveDetailOrder")
    public DetailOrder saveDetailOrder(@RequestBody DetailOrder detailOrder){
        return detailOrderService.saveDetailOrder(detailOrder);
    }

    @CrossOrigin
    @GetMapping("/findBySkuMerchant/{skuMerchant}")
    public List findBySkuMerchant(@PathVariable String skuMerchant){
        return detailOrderService.findBySkuMerchant(skuMerchant);
    }

    @CrossOrigin
    @GetMapping("/findByIdOrder/{idOrder}")
    public List findByIdOrder(@PathVariable Integer idOrder){
        return detailOrderService.findByIdOrder(idOrder);
    }

    @CrossOrigin
    @PostMapping("/updateStatusAcc/{id}")
    public DetailOrder updateStatusAcc(@PathVariable Integer id){
        return  detailOrderService.updateStatusAcc(id);
    }
}
