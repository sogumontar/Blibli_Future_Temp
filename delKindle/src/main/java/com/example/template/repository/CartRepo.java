package com.example.template.repository;

import com.example.template.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {
}
