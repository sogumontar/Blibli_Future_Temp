package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/get/{id}")
    public Product detail(@PathVariable Integer id){
        return productService.findFirstById(id);
    }
    @CrossOrigin
    @PostMapping("/simpan")
    public String simpan(@RequestPart("product") Product product1){
        try{
            Product product =  new Product(
                    product1.getTitle(),
                    product1.getDescription(),
                    product1.getCategories(),
                    product1.getPublication_year(),
                    product1.getPrice(),
                    product1.getAuthor(),
                    product1.getPublisher(),
                    product1.getIsbn());
            productService.save(product);


            return "sukses";
        }catch (Exception e){
            return e.getMessage();
        }
    }
    @CrossOrigin
    @PostMapping(value = "/createProduct")
    public String createProduct(@Valid @RequestBody Product product,@RequestParam("file") MultipartFile file) throws IOException {

        String folder = "C:/product";
        byte[] bytes = file.getBytes();
        Path path = Paths.get(folder + file.getOriginalFilename());
        Files.write(path,bytes);
        Product product1 = new Product(
                product.getTitle(),
                product.getDescription(),
                product.getCategories(),
                product.getPublication_year(),
                product.getPrice(),
                product.getAuthor(),
                product.getPublisher(),
                product.getIsbn(),
                file.getOriginalFilename());
        productService.save(product1);
        return "Sukses";

    }


    @CrossOrigin
    @PutMapping("/update/{idProduct}")
    public ResponseEntity<Object> updateProduct(@PathVariable Integer idProduct, @RequestBody Product product){
        Optional<Product> productOptional= Optional.ofNullable(productService.findFirstById(idProduct));
        if(!productOptional.isPresent())
            return ResponseEntity.notFound().build();
        product.setId(idProduct);
        productService.save(product);
        return ResponseEntity.ok().build();

    }

    @CrossOrigin
    @DeleteMapping("/del/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteById(id);
    }
//
//    @CrossOrigin
//    @PostMapping(value= "/createFile")
//    public String tambah(@Valid Product product,@RequestParam("picture_product") MultipartFile file){
//        try{
//            Product product1 = new Product(file.getBytes(),file.getBytes());
//            productService.save(product1);
//            return "berhasil";
//        }catch (Exception e){
//            return e.getMessage();
//        }
//    }
    @CrossOrigin
    @PostMapping(value= "/createFile2")
    public String tambah2(@Valid Product product, @RequestParam MultipartFile file){
        try{
            Product product1 = new Product(product.getTitle(),product.getDescription(),product.getCategories(),product.getPublication_year(),product.getPrice(),product.getAuthor(),product.getPublisher(),product.getIsbn(),product.getPictureproduct());
            productService.save(product1);
            return "berhasil";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/coba")
    public String coba(){
        return "berhasil";
    }

    @CrossOrigin
    @GetMapping("/{productId}")
    public Product findFirstById(@PathVariable  Integer productId){
        return productService.findFirstById(productId);
    }

}