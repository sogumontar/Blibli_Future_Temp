package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;




public interface ProductRepo extends JpaRepository<Product,String> {
      Product findFirstBySkuProduct(String sku);
//    Product findFirstById(String productId);
    List findAllByCategories(String kategori);
    void deleteBySkuProduct(String sku);
}
