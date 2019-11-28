package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "sku_user")
    private String skuUser;

    @Column(name = "sku_product")
    private String skuProduct;

    @Column(name = "created_at")
    private String date;

    @Column(name = "status")
    private Integer status;

    public Order(){

    }
    public Order(String id,String idUser, String idProduct, String date, Integer status) {
        this.id=id;
        this.skuUser = idUser;
        this.skuProduct = idProduct;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return skuUser;
    }

    public void setIdUser(String idUser) {
        this.skuUser = idUser;
    }

    public String getIdProduct() {
        return skuProduct;
    }

    public void setIdProduct(String idProduct) {
        this.skuProduct = idProduct;
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
