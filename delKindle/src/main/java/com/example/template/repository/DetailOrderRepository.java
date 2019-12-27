package com.example.template.repository;

import com.example.template.model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder,Integer> {
    @Query("SELECT d FROM DetailOrder d WHERE d.sku_merchant LIKE ?1 ")
    List findBySkuMerchant(String sku_merchant);

    @Query("SELECT d FROM DetailOrder d WHERE d.idOrder = ?1")
    List findByIdOrder(Integer idOrder);

    DetailOrder findFirstById(Integer id);

    List findAll();

    @Modifying
    @Query("DELETE FROM DetailOrder d WHERE d.idOrder=?1")
    void deleteByOrderId(Integer id);

    @Modifying
    @Query("UPDATE DetailOrder d set d.status=2 where d.idOrder=?1")
    void updateByIdOrder(Integer idOrder);

    @Query("SELECT d FROM DetailOrder d WHERE d.sku_user LIKE?1 AND d.status=2")
    List findLibrary(String sku_user);
}
