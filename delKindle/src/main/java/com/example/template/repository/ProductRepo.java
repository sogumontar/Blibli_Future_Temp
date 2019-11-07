package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findFirstById(long  productId);

    @Transactional
    Product deleteById(Integer productId);
    @Transactional
    Product deleteByAuthor(String author);


}
