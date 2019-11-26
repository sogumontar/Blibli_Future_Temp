package com.example.template.repository;

import com.example.template.model.Cart;
import com.example.template.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    Cart findFirstById(Integer id);

    @Query("SELECT u FROM Cart u WHERE  u.id_product=?1 ")
    Cart findFirstById_product(Integer id_product);


    @Query("SELECT COUNT(u.id) FROM Cart u WHERE u.id_user=?1 and u.id_product=?2")
    Long existsById_userAndId_product(Long id_user, Integer id_product);

    void deleteById(Integer id);
}
