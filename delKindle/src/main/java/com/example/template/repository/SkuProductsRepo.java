package com.example.template.repository;

import com.example.template.model.SkuProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuProductsRepo extends JpaRepository<SkuProducts,String> {
    public SkuProducts findByKey(String key);
    public Boolean existsByKey(String key);
}
