package com.example.template.service;

import com.example.template.model.Order;
import com.example.template.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public String add(Order order){
//        EntityManagerFactory emf= Persistence.createEntityManagerFactory("orders");
//        EntityManager em=emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Order s1=new Order();
//        s1.setId("1");
//        s1.setIdProduct(2);
//        s1.setIdUser(24);
//        s1.setStatus(1);
//        s1.setDate("123");
//        em.persist(s1);
//        em.getTransaction();
//        entityManager.createNativeQuery("INSERT INTO orders (id, id_user, id_product,status,created_at) VALUES (?,?,?,?,?)")
//                .setParameter(1, "person.getId()")
//                .setParameter(2, 2)
//                .setParameter(3, 2)
//                .setParameter(3, 2)
//                .setParameter(3, 2)
//                .executeUpdate();
        orderRepo.save(order);
        return "Sukses";
    }
}
