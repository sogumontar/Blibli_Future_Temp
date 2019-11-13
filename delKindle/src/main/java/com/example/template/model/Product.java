package com.example.template.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

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

    @Lob
    @Column(name="picture_product")
    private byte[] picture_product;

    @Lob
    @Column(name="product_file")
    private byte[] product_file;

    public Product(String title, String description, String categories, String publication_year, Integer price, String author, String publisher ,String isbn) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;

    }

    public Product(byte[] picture_product, byte[] product_file) {
        this.picture_product = picture_product;
        this.product_file = product_file;
    }

    public Product(String title, String description, String categories, String publication_year, Integer price, String author, String isbn, String publisher, byte[] picture_product, byte[] product_file) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.picture_product = picture_product;
        this.product_file = product_file;
    }

    public Product(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public byte[] getPictureproduct(){
        return this.picture_product;
    }

    public void setPictureproduct(byte[] picture_product){
        this.picture_product = picture_product;
    }

    public byte[] getProductfile(){
        return this.product_file;
    }

    public void setProductfile(byte[] productfile){
        this.product_file = productfile;
    }
}
