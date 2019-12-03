package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "id_product")
    private Integer id_product;

    @Column(name="created_at")
    private String  created_at;

    @Column(name = "status")
    private Integer status;

    @Column(name = "title")
    private String title;

    public Cart(Integer status) {
        this.status = status;
    }

    public Cart(Long id_user, Integer id_product, String created_at, Integer status) {
        this.id_user = id_user;
        this.id_product = id_product;
        this.created_at = created_at;
        this.status = status;
    }
    public Cart(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
