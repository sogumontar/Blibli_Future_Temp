package com.example.template.repository;

import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,String> {
    List findAllByCategories(String kategori);
    @Query("SELECT p FROM Product p WHERE p.sku_product LIKE ?1 ")
    Product findFirstBySku_product(String sku);

    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.sku_product LIKE?1")
    void deleteBySku_product(String sku_Product);

    @Query("SELECT p FROM Product p where p.sku_merchant LIKE?1")
    List findAllBySku_merchant(String sku_merchant);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.title=?1 , p.description=?2 , p.categories=?3 , p.publication_year=?4 , p.price=?5 , p.author=?6 , p.isbn=?7 , p.publisher=?8 WHERE p.sku_product LIKE?9")
    public void updateWithoutPict(String title, String description, String categories, String publication_year, Integer price, String author , String isbn , String publisher, String sku_product);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.title=?1 , p.description=?2 , p.categories=?3 , p.publication_year=?4 , p.price=?5 , p.author=?6 , p.isbn=?7 , p.publisher=?8 WHERE p.sku_product LIKE?9")
    public void updateWithPict(String title, String description, String categories, String publication_year, Integer price, String author , String isbn , String publisher, String sku_product);
}
