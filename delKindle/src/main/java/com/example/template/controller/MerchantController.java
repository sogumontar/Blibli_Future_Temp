package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.payload.CatalogEntryRequest;
import com.example.template.payload.DeleteProductResponse;
import com.example.template.service.LastProductService;
import com.example.template.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Base64;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @Autowired
    LastProductService lastProductService;


    @CrossOrigin
    @GetMapping("/getAllByMerchant/{SkuMerchant}")
    public List getAllByMerchant(@PathVariable String SkuMerchant){
        return merchantService.findBySkuMerchant(SkuMerchant);
    }

    @CrossOrigin
    @GetMapping("/countIdMerchant/{SkuMerchant}")
    public Integer countIdMerchant(@PathVariable String SkuMerchant){
        return merchantService.countByIdMerchant(SkuMerchant);
    }

//    @CrossOrigin
//    @PostMapping("/deleteById/{Id}")
//    public ResponseEntity<?> deleteById(@PathVariable Integer Id){
//       merchantService.deleteById(Id);
//       return ResponseEntity.ok(new DeleteProductResponse());
//    }

//    @CrossOrigin
//    @GetMapping("/get/{id}")
//    public Product detail(@PathVariable Integer id){
//        return merchantService.findFirstById(id);
//    }

    @CrossOrigin
    @PostMapping("/addProductImage")
    public void  addProduct(@RequestBody CatalogEntryRequest catalogEntryRequest){
         merchantService.addProduct(catalogEntryRequest);
    }

    @CrossOrigin
    @PostMapping("/addBook")
    public void addBook(@RequestBody CatalogEntryRequest catalogEntryRequest){
       merchantService.addBook(catalogEntryRequest);
    }

    @CrossOrigin
    @PostMapping("/saveProduct")
    public String saveProduct(@RequestBody CatalogEntryRequest catalogEntryRequest){
       return merchantService.saveProduct(catalogEntryRequest);
    }
}
