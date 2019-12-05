package com.example.template.repository;

import com.example.template.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


    User findByUsername(String username);

    List<User> findByName(String name);

    User findFirstBySku(String sku);

    User findBySku(String sku);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name=?1 , u.email=?2 ,u.username=?3,u.telepon=?4, u.alamat=?5 WHERE u.sku LIKE ?6 ")
    void update(String name,String email,String username,String telepon,String alamat,String sku);
}
