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
    LastProductService lastProductService;
    @Autowired
    ProductRepo productRepo;

//    @Autowired
//    SkuProductsService skuProductsService;
//    public void deleteById(Integer id){
//        productRepo.deleteById(id);
//    }

    public List findAll(){
        return productRepo.findAll();
    }

    public Product findFirstBySku(String sku){

        return productRepo.findFirstBySku_product(sku);
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

    public void deleteBySkuProduct(String skuProduct){
        productRepo.deleteBySku_product(skuProduct);
    }
    public List findAllBySkuMerchant(String skuMerchant){
        return productRepo.findAllBySku_merchant(skuMerchant);
    }
    public String updateWithoutPict(String title, String description, String categories, String publication_year, Integer price, String author , String isbn , String publisher, String sku_product){
        productRepo.updateWithoutPict(title,description,categories,publication_year,price,author,isbn,publisher,sku_product);
        return "Update Success";
    }
    public String updateWithPict(String title, String description, String categories, String publication_year, Integer price, String author , String isbn , String publisher, String sku_product){

        productRepo.updateWithPict(title,description,categories,publication_year,price,author,isbn,publisher,sku_product);
        return "Update Success";
    }

    public Product editProduct(Product product){
        return productRepo.findFirstBySku_product(product.getSku_merchant());
    }
}

