package com.example.template.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sku_merchant")
    private String sku_merchant;

    @Column(name = "total_mon")
    private Integer total_mon;

    public Money(String sku_merchant, Integer total_mon) {
        this.sku_merchant = sku_merchant;
        this.total_mon = total_mon;
    }
    public Money(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku_merchant() {
        return sku_merchant;
    }

    public void setSku_merchant(String sku_merchant) {
        this.sku_merchant = sku_merchant;
    }

    public Integer getTotal_mon() {
        return total_mon;
    }

    public void setTotal_mon(Integer total_mon) {
        this.total_mon = total_mon;
    }
}
