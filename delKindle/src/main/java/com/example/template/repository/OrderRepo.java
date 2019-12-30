package com.example.template.repository;

import com.example.template.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {

    @Query(value = "SELECT * FROM orders  ORDER BY id desc LIMIT 1",nativeQuery = true)
    Orders findLast();

    @Query("SELECT o FROM Orders o")
    List getAll();

    @Query(value = "SELECT o FROM Orders o where o.skuUser LIKE ?1")
    List findBySkuUser(String SkuUser);

    @Query(value = "SELECT o FROM Orders o WHERE o.virtualaccount LIKE ?1")
    List findByVirtualaccount(String virtual);

    Orders findFirstById(Integer id);

    List findAllBySkuUserAndStatus(String sku,Integer status);

    @Transactional
    @Modifying
    @Query("DELETE FROM Orders o WHERE o.id =?1")
    void deleteById(Integer id);

    @Query("SELECT o FROM Orders o where o.id=?1")
    Orders findById(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Orders o set o.status=2 where o.id=?1")
    void updateOrdersById(Integer id);
}
