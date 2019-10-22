package medan.sitoluama.delKindle.delKindle.controller;


import medan.sitoluama.delKindle.delKindle.Model.Product;
import medan.sitoluama.delKindle.delKindle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PostMapping("/createProduct")
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.save(product);
    }

    @CrossOrigin
    @GetMapping("/coba")
    public String coba(){
        return "coba";
    }

    @CrossOrigin
    @PostMapping(value= "/tambah", produces = "application/json")
    public Product tambah(@Valid @RequestBody Product product){
        return productService.save(product);
    }
}
