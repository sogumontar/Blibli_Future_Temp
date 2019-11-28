package com.example.template.controller;

import com.example.template.model.Product;
import com.example.template.payload.DeleteProductResponse;
import com.example.template.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/merchant")
public class MerchantController {
//
//    @Autowired
//    MerchantService merchantService;
//
//    @CrossOrigin
//    @PostMapping("/saveProduct")
//    public String simpan(@RequestPart("product") Product product1, @RequestPart("file") MultipartFile file){
//        try{
//            Product product =  new Product(
//                    product1.getTitle(),
//                    product1.getDescription(),
//                    product1.getCategories(),
//                    product1.getPublication_year(),
//                    product1.getPrice(),
//                    product1.getAuthor(),
//                    product1.getPublisher(),
//                    product1.getIsbn(),
//                    file.getOriginalFilename(),
//                    product1.getId_merchant()
//            );
//
//            merchantService.save(product);
//            System.out.println(product1.getTitle());
//            System.out.println(product1.getDescription());
//            System.out.println(file.getOriginalFilename());
//
//            String folder = "C:/product/";
//            byte[] bytes = file.getBytes();
//            Path path = Paths.get(folder + file.getOriginalFilename());
//            Files.write(path,bytes);
//
//            return "sukses";
//        }catch (Exception e){
//            return e.getMessage();
//        }
//    }
//
//
//    @CrossOrigin
//    @GetMapping("/getAllByMerchant/{idMerchant}")
//    public List getAllByMerchant(@PathVariable Integer idMerchant){
//        return merchantService.findByIdMerchant(idMerchant);
//    }
//
//    @CrossOrigin
//    @GetMapping("/countIdMerchant/{idMerchant}")
//    public Integer countIdMerchant(@PathVariable Integer idMerchant){
//        return merchantService.countByIdMerchant(idMerchant);
//    }
//
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
}
