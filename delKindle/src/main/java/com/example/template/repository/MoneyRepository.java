package com.example.template.repository;

import com.example.template.model.Money;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MoneyRepository extends JpaRepository<Money,Integer> {
    @Query("SELECT m FROM Money m where m.sku_merchant = ?1")
    Money findFirstBySku_merchant(String sku_merchant);

    @Query("SELECT COUNT(m) FROM Money m WHERE m.sku_merchant LIKE ?1")
    Integer existBySkuMerchant(String skuMerchant);

    @Modifying
    @Transactional
    @Query("UPDATE Money m SET m.total_mon = ?1 WHERE m.sku_merchant LIKE ?2")
    void updateMoney(Integer tot_money,String skuMerchant);
}
