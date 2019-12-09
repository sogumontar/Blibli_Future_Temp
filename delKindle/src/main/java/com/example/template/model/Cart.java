package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="created_at")
    private String  created_at;

    @Column(name = "status")
    private Integer status;


    @Column(name = "title")
    public String title;

    @Column(name = "pict_product")
    public String pict_product;


    @Column(name = "categories")
    public String categories;

    @Column(name = "publication_year")
    public String publication_year;

    @Column(name = "price")
    public Integer price;

    @Column(name = "author")
    public String author;

    @Column(name = "publisher")
    public String publisher;

    @Column(name = "isbn")
    public String isbn;

    @Column(name = "sku_user")
    private String sku_user;

    @Column(name = "sku_product")
    private String sku_product;

    @Column(name = "sku_merchant")
    private String sku_merchant;
    public Cart(){

    }
    public Cart(String created_at, Integer status, String title, String pict_product, String categories, String publication_year, Integer price, String author, String publisher, String isbn, String sku_user, String sku_product) {
        this.created_at = created_at;
        this.status = status;
        this.title = title;
        this.pict_product = pict_product;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.sku_user = sku_user;
        this.sku_product = sku_product;
    }

    public Cart(String created_at, Integer status, String title, String pict_product, String categories, String publication_year, Integer price, String author, String publisher, String isbn, String sku_user, String sku_product, String sku_merchant) {
        this.created_at = created_at;
        this.status = status;
        this.title = title;
        this.pict_product = pict_product;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.sku_user = sku_user;
        this.sku_product = sku_product;
        this.sku_merchant = sku_merchant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPict_product() {
        return pict_product;
    }

    public void setPict_product(String pict_product) {
        this.pict_product = pict_product;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSku_user() {
        return sku_user;
    }

    public void setSku_user(String sku_user) {
        this.sku_user = sku_user;
    }

    public String getSku_product() {
        return sku_product;
    }

    public void setSku_product(String sku_product) {
        this.sku_product = sku_product;
    }

    public String getSku_merchant() {
        return sku_merchant;
    }

    public void setSku_merchant(String sku_merchant) {
        this.sku_merchant = sku_merchant;
    }
}
