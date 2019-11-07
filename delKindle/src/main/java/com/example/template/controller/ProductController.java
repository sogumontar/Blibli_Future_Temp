package com.example.template.controller;

import com.example.template.model.Account;
import com.example.template.model.Product;
import com.example.template.payload.ProductRequest;
import com.example.template.payload.RegisterRequest;
import com.example.template.repository.ProductRepo;
import com.example.template.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;


    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return productService.findAll();
    }

    @CrossOrigin
    @PostMapping("/insert")
    @RequestMapping("/insert")
    public Product save(@Valid @RequestBody Product product){
        return productService.save(product);
    }
    @CrossOrigin
    @GetMapping("/{productId}")
    public Product findFirstById(@PathVariable  Integer productId){
        return productService.findFirstById(productId);
    }


<<<<<<< HEAD
    @CrossOrigin
    @GetMapping("/{productId}")
    public Product findFirstById(@PathVariable  Integer productId){
        return productService.findFirstById(productId);
    }
    @CrossOrigin
    @PostMapping(value = "/simpan")
    public String simpan(@RequestPart("product") Product product1,@RequestPart("file") MultipartFile file){
=======
    @CrossOrigin
    @PostMapping("/simpan")
    public String simpan(Product product1,@RequestParam MultipartFile file){
>>>>>>> e737da82e7c6129323de9065d132c4719b1c6f0c
        try{
//            Product product =  new Product(
//                    product1.getTitle(),
//                    product1.getDescription(),
//                    product1.getCategories(),
//                    product1.getPublication_year(),
//                    product1.getPrice(),
//                    product1.getAuthor(),
//                    product1.getPublisher(),
//                    product1.getIsbn(),
//                    file.getOriginalFilename());
//
//            productService.save(product);
            System.out.println(product1.getTitle());
            System.out.println(product1.getDescription());
            System.out.println(file.getOriginalFilename());

            String folder = "C:/product/";
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + file.getOriginalFilename());
            Files.write(path,bytes);

            return "sukses";
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
