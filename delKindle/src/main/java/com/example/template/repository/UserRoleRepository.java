package com.example.template.repository;

import com.example.template.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    @Query("SELECT u FROM UserRole u WHERE u.sku_user = ?1")
    UserRole findBySku_user(String sku_user);


}
