package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List findIndex(){
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/kategori/{kategori}")
    public List findAllByCategories(@PathVariable String kategori){
        return productService.findAllByCategories(kategori);
    }

    @CrossOrigin
    @GetMapping("/getAll")
    public List findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @GetMapping("/get/{sku}")
    public Product detail(@PathVariable String sku){
        return productService.findFirstBySku(sku);
    }
//    @CrossOrigin
//    @PostMapping("/simpan")
//    public String simpan(@RequestPart("product") Product product1){
//        try{
//            Product product =  new Product(
//                    product1.getTitle(),
//                    product1.getDescription(),
//                    product1.getCategories(),
//                    product1.getPublication_year(),
//                    product1.getPrice(),
//                    product1.getAuthor(),
//                    product1.getPublisher(),
//                    product1.getIsbn());
//            productService.save(product);
//
//
//            return "sukses";
//        }catch (Exception e){
//            return e.getMessage();
//        }
//    }


    @CrossOrigin
    @GetMapping(value = "/coba")
    public String coba(){
        return "berhasil";
    }

    @CrossOrigin
    @GetMapping("/allByMerchant/{sku_merchant}")
    public List findAllBySkuMerchant(@PathVariable String sku_merchant){
        return productService.findAllBySkuMerchant(sku_merchant);
    }
    @CrossOrigin
    @Modifying
    @PutMapping("/updateWithoutPict/{title}/{description}/{categories}/{publication_year}/{price}/{author}/{isbn}/{publisher}/{sku_product}")
    public void updateWithoutPict(@PathVariable String title,@PathVariable String description,@PathVariable String categories,@PathVariable String publication_year,@PathVariable Integer price,@PathVariable String author ,@PathVariable String isbn ,@PathVariable String publisher,@PathVariable String sku_product){
        productService.updateWithoutPict(title,description,categories,publication_year,price,author,isbn,publisher,sku_product);
    }
    @CrossOrigin
    @Modifying
    @PutMapping("/updateWithPict/{title}/{description}/{categories}/{publication_year}/{price}/{author}/{isbn}/{publisher}/{sku_product}")
    public void updateWithPict(@PathVariable String title,@PathVariable String description,@PathVariable String categories,@PathVariable String publication_year,@PathVariable Integer price,@PathVariable String author ,@PathVariable String isbn ,@PathVariable String publisher,@PathVariable String sku_product){
        productService.updateWithPict(title,description,categories,publication_year,price,author,isbn,publisher,sku_product);
    }

    @CrossOrigin
    @Modifying
    @PostMapping("/editProduct")
    public Product editProduct(@RequestBody Product product){
        return productService.editProduct(product);
    }
}