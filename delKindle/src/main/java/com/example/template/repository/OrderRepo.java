package com.example.template.repository;

import com.example.template.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {

}
