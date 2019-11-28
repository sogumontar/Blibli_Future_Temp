package com.example.template.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String sku_user;

    @NotBlank
    @Size(max = 40)
    private Integer role_id;

    public String getSku_user() {
        return sku_user;
    }

    public void setSku_user(String sku_user) {
        this.sku_user = sku_user;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}