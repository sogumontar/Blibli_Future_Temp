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
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;


    @Autowired
    ProductService productService;

    @CrossOrigin
    @DeleteMapping("/del/{id}")
    public Product deleteProduct(@PathVariable Integer id){
        return productService.deleteById(id);
    }

    @DeleteMapping("/delete/{author}")
    public Product deleteByAuthor(String author){
        return productService.deleteByAuthor(author);
    }

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

    @CrossOrigin
    @PostMapping("/simpan")
    public String simpan(@RequestPart("product") Product product1,@RequestPart("file") MultipartFile file){
        try{
            Product product =  new Product(
                    product1.getTitle(),
                    product1.getDescription(),
                    product1.getCategories(),
                    product1.getPublication_year(),
                    product1.getPrice(),
                    product1.getAuthor(),
                    product1.getPublisher(),
                    product1.getIsbn(),
                    file.getOriginalFilename());

            productService.save(product);

            String folder = "C:/product/";
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + file.getOriginalFilename());
            Files.write(path,bytes);

            return "sukses";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @CrossOrigin
    @PutMapping("/update/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer idProduct, @RequestBody Product product) throws IOException {
        Optional<Product> productOptional= Optional.ofNullable(productRepo.findFirstById(idProduct));
        if(!productOptional.isPresent())
            return ResponseEntity.notFound().build();
        product.setId(idProduct);
        product.setId(idProduct);
        productService.save(product);
//                file.getOriginalFilename());
//        productService.save(product1);
//        String folder = "C:/product/";
//        byte[] bytes = file.getBytes();
//        Path path = Paths.get(folder + file.getOriginalFilename());
//        Files.write(path,bytes);
        return ResponseEntity.ok().build();

    }


}
