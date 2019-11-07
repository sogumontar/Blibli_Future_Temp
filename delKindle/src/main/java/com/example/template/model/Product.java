package com.example.template.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "categories")
    private String categories;

    @Column(name = "publication_year")
    private String publication_year;

    @Column(name = "price")
    private long price;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "pict_product")
    private String pictProduct;

    public Product(){

    }
    public Product(String title, String description, String categories, String publication_year, long price, String author, String publisher, String isbn) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pictProduct = pictProduct;
    }

    public Product(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Product(String title, String description, String categories, String publication_year, long price, String author, String publisher, String isbn, String pictProduct) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pictProduct = pictProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPictProduct() {
        return pictProduct;
    }

    public void setPictProduct(String pictProduct) {
        this.pictProduct = pictProduct;
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


    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return price;
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
}
