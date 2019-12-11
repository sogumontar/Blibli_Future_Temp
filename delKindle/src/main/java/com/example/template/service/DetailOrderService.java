package com.example.template.service;

import com.example.template.model.DetailOrder;
import com.example.template.repository.DetailOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrderService {

    @Autowired
    DetailOrderRepository detailOrderRepository;

    @Autowired
    DetailOrderService detailOrderService;

    public DetailOrder save(DetailOrder detailOrder){
        return detailOrderRepository.save(detailOrder);
    }

    public DetailOrder saveDetailOrder(DetailOrder detailOrder){
        return  detailOrderService.save(detailOrder);
    }

    public List findBySkuMerchant(String skuMerchant){
        return detailOrderRepository.findBySkuMerchant(skuMerchant);
    }
    public List findAll(){
        return detailOrderRepository.findAll();
    }
}
