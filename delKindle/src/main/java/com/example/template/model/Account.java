package com.example.template.model;

import com.example.template.model.constants.AccountConstant;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = AccountConstant.Name)
    private String name;

    @Column(name = AccountConstant.Username)
    private String username;

    @Column(name = AccountConstant.Email)
    private String email;

    @Column(name = AccountConstant.Password)
    private String password;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    public Account(){

    }
    public Account(String email,String name,String username ,String password,String created_at){
        this.email=email;
        this.name=name;
        this.username=username;
        this.password=password;
        this.created_at=created_at;
    }


    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
