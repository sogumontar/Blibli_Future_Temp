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

    @Column(name = "telepon")
    private String telepon;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tanggal_lahir")
    private String tanggal_lahir;

    public Account(String telepon, String alamat, String tanggal_lahir, String name, String username, String email, String password, String created_at) {
        this.telepon = telepon;
        this.alamat = alamat;
        this.tanggal_lahir = tanggal_lahir;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.created_at = created_at;
    }

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


    public Account(){

    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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
