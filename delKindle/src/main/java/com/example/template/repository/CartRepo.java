package com.example.template.repository;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
//    @Query("SELECT new Product(d.title, d.description, d.categories, d.publication_year) "
//            + "FROM Product d JOIN Cart c ON c.id_product=d.id")
//    List<Product> dat();
    List findById(Integer id);

}
