package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "created_at")
    private String date;

    @Column(name = "status")
    private Integer status;

    public Order(){

    }
    public Order(Integer idUser, Integer idProduct, String date, Integer status) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
