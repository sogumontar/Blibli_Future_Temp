package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "wislist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "id_product")
    private Integer id_product;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private String created_at;

    public Wishlist(){

    }
    public Wishlist(Integer id_user, Integer id_product, Integer status, String created_at) {
        this.id_user = id_user;
        this.id_product = id_product;
        this.status = status;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
