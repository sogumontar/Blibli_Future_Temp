package com.example.template.controller;

import com.example.template.model.DetailOrder;
import com.example.template.service.DetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/detailOrder")
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
    @GetMapping("/findAll")
    public List findAll(){
        return detailOrderService.findAll();
    }


    @CrossOrigin
    @DeleteMapping("/delByOrderId/{id}")
    @Transactional
    public String deleteDetailOrderByOrderId(@PathVariable Integer id){
        detailOrderService.deleteByDetailOrderId(id);
        return "Success delete Detail Order";
    }

    @CrossOrigin
    @Transactional
    @PutMapping("/updateByIdOrder/{idOrder}")
    public void updateByIdOrder(@PathVariable Integer idOrder){
        detailOrderService.updateByIdOrder(idOrder);
    }

    @CrossOrigin
    @GetMapping("/findLibrary/{sku_user}")
    public List findLibrary(String sku_user){
        return detailOrderService.findLibrary(sku_user);
    }

}
