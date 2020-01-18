package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "detail_order")
public class DetailOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Integer id;

    @Column(name = "sku_product")
    public String sku_product;

    @Column(name = "sku_merchant")
    public String sku_merchant;

    @Column(name = "id_order")
    public Integer idOrder;

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

    @Column(name = "status")
    public Integer status;

    @Column(name = "name")
    public String name;

    @Column(name = "sku_user")
    public String sku_user;

    @Column(name = "book")
    public String book;

    public DetailOrder(){

    }

    public DetailOrder(String sku_product, String sku_merchant, Integer idOrder, String title, String pict_product, String categories, String publication_year, Integer price, String author, String publisher, String isbn,Integer status,String name) {
        this.sku_product = sku_product;
        this.sku_merchant = sku_merchant;
        this.idOrder = idOrder;
        this.title = title;
        this.pict_product = pict_product;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.status = status;
        this.name = name;
    }

    public DetailOrder(String sku_product, String sku_merchant, Integer idOrder, String title, String pict_product, String categories, String publication_year, Integer price, String author, String publisher, String isbn, Integer status, String name, String sku_user) {
        this.sku_product = sku_product;
        this.sku_merchant = sku_merchant;
        this.idOrder = idOrder;
        this.title = title;
        this.pict_product = pict_product;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.status = status;
        this.name = name;
        this.sku_user = sku_user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku_user() {
        return sku_user;
    }

    public void setSku_user(String sku_user) {
        this.sku_user = sku_user;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
