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

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "virtualaccount")
    private String virtualaccount;

    @Column(name = "tipe_trans")
    private Integer tipeTrans;

    @Column(name = "tot_transaction")
    private Integer totTrans;

    public Orders(){

    }

    public Orders(String skuUser, Integer status, String createdAt, String virtualaccount, Integer tipeTrans,Integer totTrans) {
        this.skuUser = skuUser;
        this.status = status;
        this.createdAt = createdAt;
        this.virtualaccount = virtualaccount;
        this.tipeTrans = tipeTrans;
        this.totTrans = totTrans;
    }

    public Orders(String skuUser, String skuProducts, int i, String toString) {
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

    public String getVirtualaccount() {
        return virtualaccount;
    }

    public void setVirtualaccount(String virtualaccount) {
        this.virtualaccount = virtualaccount;
    }

    public Integer getTipeTrans() {
        return tipeTrans;
    }

    public void setTipeTrans(Integer tipeTrans) {
        this.tipeTrans = tipeTrans;
    }

    public Integer getTotTrans() {
        return totTrans;
    }

    public void setTotTrans(Integer totTrans) {
        this.totTrans = totTrans;
    }
}
