package com.example.template.service;


import com.example.template.model.Product;
import com.example.template.repository.ProductRepo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    SkuProductsService skuProductsService;
    public void deleteBySkuProduct(String sku){
        productRepo.deleteBySkuProduct(sku);
    }
    public List findAll(){
        return productRepo.findAll();
    }

    public Product findFirstBySkuProduct(String sku){

        return productRepo.findFirstBySkuProduct(sku);
    }

    public Product save(Product product){

//        String sku=product.getTitle().substring(0,3)+"_"+"_001";
//
//        String generatedString = RandomStringUtils.randomAlphanumeric(20);
//        if(!skuProductsService.existsByKey(sku)){
//            sku=product.getTitle().substring(0,3)+"_"+"001"+"_001";
//        }else {
//
//            sku=product.getTitle().substring(0,3)+"_"+"001"+"_001";
//        }
//        Product product1 = new Product(
//                sku,
//                product.getTitle(),
//                product.getDescription(),
//                product.getCategories(),
//                product.getPublication_year(),
//                product.getPrice(),
//                product.getAuthor(),
//                product.getIsbn(),
//                product.getPublisher(),
//                product.getPict_product(),
//                product.getId_merchant()
//        );
        return productRepo.save(product);
    }


    public List findAllByCategories(String kategori){
        return productRepo.findAllByCategories(kategori);
    }
}

