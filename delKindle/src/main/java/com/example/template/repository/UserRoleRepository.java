package com.example.template.repository;

import com.example.template.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("SELECT u FROM UserRole u WHERE u.user_id = ?1")
    UserRole findByUser_id(Long userId);


}
