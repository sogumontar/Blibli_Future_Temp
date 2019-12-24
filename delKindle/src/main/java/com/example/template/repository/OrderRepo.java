package com.example.template.repository;

import com.example.template.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Order;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {

    @Query(value = "SELECT * FROM orders  ORDER BY id desc LIMIT 1",nativeQuery = true)
    Orders findLast();

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
