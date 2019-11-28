package com.example.template.repository;

import com.example.template.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,String> {

}
