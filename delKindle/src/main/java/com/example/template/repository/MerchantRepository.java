package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MerchantRepository extends JpaRepository<Product,Integer> {
    Product findFirstById(Integer productId);

    List findAllByCategories(String kategori);

    @Query("SELECT u FROM Product u WHERE u.id_merchant = ?1")
    List findById_merchant(Integer id_merchant);
}
