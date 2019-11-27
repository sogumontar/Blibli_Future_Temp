package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;




public interface ProductRepo extends JpaRepository<Product,Integer> {
    Product findFirstById(Integer productId);
    List findAllByCategories(String kategori);
    void deleteById(Integer id);
}
