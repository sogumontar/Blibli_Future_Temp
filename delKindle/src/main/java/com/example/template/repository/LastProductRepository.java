package com.example.template.repository;

import com.example.template.model.LastProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LastProductRepository extends JpaRepository<LastProduct,Integer> {
    @Query(value = "SELECT * FROM last_product  ORDER BY last_book desc LIMIT 1",nativeQuery = true)
    LastProduct findLast();
}
