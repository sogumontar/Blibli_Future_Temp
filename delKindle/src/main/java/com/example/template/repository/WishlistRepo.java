package com.example.template.repository;

import com.example.template.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist,Long> {

    Wishlist findFirstById(Integer id);

}
