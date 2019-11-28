package com.example.template.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sku_users")
public class SkuProducts {
    @Id
    private String id;
    private String key;
    private String last_key;
    private boolean status;

    public SkuProducts(String id, String key, String last_key, boolean status) {
        this.id = id;
        this.key = key;
        this.last_key = last_key;
        this.status = status;
    }

    public SkuProducts(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLast_key() {
        return last_key;
    }

    public void setLast_key(String last_key) {
        this.last_key = last_key;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
