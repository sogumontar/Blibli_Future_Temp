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
          int last = lastProductService.findLast().getLast_book();
          String pict = "pict"+last+".jpg";
          File file = new File("C:/product/"+pict);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] decoder = Base64.getDecoder().decode(catalogEntryRequest.getPict_product());
            fos.write(decoder);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/addBook")
    public void addBook(@RequestBody CatalogEntryRequest catalogEntryRequest){
        int last = lastProductService.findLast().getLast_book();
        String pdf = "book"+last+".pdf";
        File file = new File("C:/product/book/"+pdf);
        try(FileOutputStream fos = new FileOutputStream(file)){
            byte[] decoder = Base64.getDecoder().decode(catalogEntryRequest.getBook_file());
            fos.write(decoder);
            System.out.println("Image file saved");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody CatalogEntryRequest catalogEntryRequest){
       return merchantService.saveProduct(catalogEntryRequest);
    }
}
