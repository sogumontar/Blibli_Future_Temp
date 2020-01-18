package com.example.template.controller;

import com.example.template.model.Money;
import com.example.template.repository.MoneyRepository;
import com.example.template.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    MoneyService moneyService;

    @Autowired
    MoneyRepository moneyRepository;

    @CrossOrigin
    @GetMapping("/findAll")
    public List findAll(){
        return moneyService.findAll();
    }

    @CrossOrigin
    @GetMapping("/findBySkuMerchant/{skuMerchant}")
    public Money findFristBySkuMerchant(@PathVariable String skuMerchant){
        return  moneyService.findFirstBySkuMerchant(skuMerchant);
    }

    @CrossOrigin
    @GetMapping("/existBySkuMerchant/{skuMerchant}")
    public Integer existBySkuMerchant(@PathVariable String skuMerchant){
        return moneyService.exisBySkuMerchant(skuMerchant);
    }

    @CrossOrigin
    @PostMapping("/updateMoney/{tot_money}/{skuMerchant}")
    public void updateMoney(@PathVariable Integer tot_money,@PathVariable String skuMerchant){
        moneyService.updateMoney(tot_money,skuMerchant);
    }

    @CrossOrigin
    @PostMapping("/saveMoney")
    public Money saveMoney(@RequestBody Money money){
        return moneyService.save(money);
    }


}
