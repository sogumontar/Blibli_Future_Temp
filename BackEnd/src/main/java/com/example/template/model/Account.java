package com.example.template.model;

import com.example.template.model.constants.AccountConstant;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Account {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
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
