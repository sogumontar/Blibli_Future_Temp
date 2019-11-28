package com.example.template.controller;
import com.example.template.model.LastProduct;
import com.example.template.service.LastProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LastProduct")
public class LastProductController {

    @Autowired
    LastProductService lastProductService;

    @GetMapping("/findLast")
    public LastProduct findLast(){
        return lastProductService.findLast();
    }


}