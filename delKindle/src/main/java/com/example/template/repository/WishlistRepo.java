package com.example.template.repository;

import com.example.template.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,Long> {

    Wishlist findFirstById(Integer id);

    @Query("SELECT COUNT(u.id) FROM Wishlist u WHERE u.sku_user LIKE ?1 and u.sku_product LIKE ?2")
    Integer existsBySku_userAndSku_product(String sku_user, String sku_product);

    void deleteById(Integer id);

}
