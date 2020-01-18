package com.example.template.service;

import com.example.template.model.Money;
import com.example.template.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {

    @Autowired
    MoneyRepository moneyRepository;

    public List findAll(){
        return moneyRepository.findAll();
    }

    public Money findFirstBySkuMerchant(String skuMerchant){
        return moneyRepository.findFirstBySku_merchant(skuMerchant);
    }

    public Integer exisBySkuMerchant(String skuMerchant){
        return moneyRepository.existBySkuMerchant(skuMerchant);
    }

    public void updateMoney(Integer tot_money,String skuMerchant){
        moneyRepository.updateMoney(tot_money,skuMerchant);
    }

    public Money save(Money money){
        Money money1 = new Money();
        money1.setSku_merchant(money.getSku_merchant());
        money1.setTotal_mon(money.getTotal_mon());
        return moneyRepository.save(money1);
    }



}
