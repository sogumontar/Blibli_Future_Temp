package com.example.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Product {


    @Id
    @Column(name ="sku_product")
    private String sku_product;

    @Column(name ="title")
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name ="categories")
    private String categories;


    @Column(name ="publication_year")
    private String publication_year;

    @Column(name ="price")
    private Integer price;

    @Column(name ="author")
    private String author;

    @Column(name ="isbn")
    private String isbn;

    @Column(name ="publisher")
    private String publisher;


    @Column(name="pict_product")
    private String pict_product;

    @Column(name="book_file")
    private String book_file;

    @Column(name="sku_merchant")
    private String sku_merchant;


    public Product(String sku_product,String title, String description, String categories, String publication_year, Integer price, String author, String publisher, String isbn, String pict_product,String book_file, String sku_merchant) {
        this.sku_product = sku_product;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.pict_product = pict_product;
        this.book_file = book_file;
        this.sku_merchant = sku_merchant;
    }

    public Product(String sku_product, String title, String description, String categories, String publication_year, Integer price, String author, String publisher, String isbn, String sku_merchant) {
        this.sku_product = sku_product;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.sku_merchant = sku_merchant;
    }

    public String getPict_product() {
        return pict_product;
    }

    public void setPict_product(String pict_product) {
        this.pict_product = pict_product;
    }
    public Product(){

    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getBook_file() {
        return book_file;
    }

    public void setBook_file(String book_file) {
        this.book_file = book_file;
    }


}
