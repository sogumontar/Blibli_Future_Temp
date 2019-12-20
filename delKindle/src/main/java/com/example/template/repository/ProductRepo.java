package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,String> {
    List findAllByCategories(String kategori);
    @Query("SELECT p FROM Product p WHERE p.sku_product LIKE ?1 ")
    Product findFirstBySku_product(String sku);


}
