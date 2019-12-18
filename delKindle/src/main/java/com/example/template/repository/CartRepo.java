package com.example.template.repository;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {
    Cart findFirstById(Integer id);

    @Query("SELECT u FROM Cart u WHERE  u.sku_product=?1 ")
    Cart findFirstBySku_product(String sku_product);


    @Query("SELECT COUNT(u.id) FROM Cart u WHERE u.sku_user LIKE ?1 and u.sku_product LIKE ?2")
    Integer existsBySku_userAndSku_product(String sku_user, String sku_product);

    @Query("SELECT c FROM Cart c WHERE c.sku_user=?1")
    Cart findAllBySku_user(String id);

    void deleteById(Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.status=2 WHERE c.sku_user LIKE ?1 ")
    void updateAll(String sku_user);


    @Modifying
    @Transactional
    @Query("UPDATE Cart c SET c.status=3 WHERE c.sku_user LIKE ?1 AND c.status=2")
    List akhir(String sku_user);
}
