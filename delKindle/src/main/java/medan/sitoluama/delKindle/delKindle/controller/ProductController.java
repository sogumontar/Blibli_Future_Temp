package medan.sitoluama.delKindle.delKindle.controller;


import medan.sitoluama.delKindle.delKindle.Model.Product;
import medan.sitoluama.delKindle.delKindle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @CrossOrigin
    @GetMapping("/")
    public List findAll(){
        return productService.findAll();
    }

//    @CrossOrigin
//    @PostMapping("/createProduct")
//    public Product createProduct(@Valid @RequestBody Product product){
//        return productService.save(product);
//    }
    @CrossOrigin
    @PostMapping(value = "/createProduct")
    public Product createProduct(@Valid @RequestBody Product product){
        Product product1 = new Product(product.getTitle(),product.getDescription(),product.getCategories(),product.getPublication_year(),product.getPrice(),product.getAuthor(),product.getPublisher(),product.getIsbn());
        return productService.save(product1);
    }

    @CrossOrigin
    @PostMapping(value= "/createFile")
    public String tambah(@Valid @RequestBody Product product,@RequestParam("picture_product") MultipartFile file){
        try{
            Product product1 = new Product(file.getBytes(),file.getBytes());
            productService.save(product1);
            return "berhasil";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
