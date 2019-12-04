package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sku_user")
    private String skuUser;

    @Column(name = "sku_product")
    private String skuProduct;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private String createdAt;

    public Orders(){

    }

    public Orders(String skuUser, String skuProduct, Integer status, String createdAt) {
        this.skuUser = skuUser;
        this.skuProduct = skuProduct;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkuUser() {
        return skuUser;
    }

    public void setSkuUser(String skuUser) {
        this.skuUser = skuUser;
    }

    public String getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(String skuProduct) {
        this.skuProduct = skuProduct;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
