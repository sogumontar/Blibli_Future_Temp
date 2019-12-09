package com.example.template.controller;

import com.example.template.model.SeqProduct;
import com.example.template.service.SeqProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/SeqProduct")
public class SeqProductController {
    @Autowired
    SeqProductService seqProductService;

    @CrossOrigin
    @GetMapping("/existByKey/{key}")
    public boolean existByKey(@PathVariable String key){
        return seqProductService.existByKey(key);
    }

    @CrossOrigin
    @GetMapping("/findFirstByKey/{key}")
    public SeqProduct findFistByKey(@PathVariable String key){
        return seqProductService.findFirstByKey(key);
    }

}
