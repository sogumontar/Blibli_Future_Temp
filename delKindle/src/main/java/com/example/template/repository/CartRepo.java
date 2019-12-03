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
    Cart findFirstById(Integer id);

    @Query("SELECT u FROM Cart u WHERE  u.sku_product=?1 ")
    Cart findFirstBySku_product(String sku_product);


    @Query("SELECT COUNT(u.id) FROM Cart u WHERE u.sku_user=?1 and u.sku_product=?2")
    Long existsBySku_userAndSku_product(String sku_user, String sku_product);

    @Query("SELECT c FROM Cart c WHERE c.sku_user=?1")
    Cart findAllBySku_user(String id);

    void deleteById(Integer id);
}
