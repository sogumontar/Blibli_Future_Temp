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
    private String skuProduct;

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

    @Column(name="id_merchant")
    private Integer id_merchant;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "cart",
            joinColumns = {@JoinColumn(name = "id_product")},
            inverseJoinColumns ={@JoinColumn(name = "sku_user")})
    Set<User>users=new HashSet<>();
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


    public Product(String skuProduct, String title, String description, String categories, String publication_year, Integer price, String author, String isbn, String publisher, String pict_product, Integer id_merchant) {
        this.skuProduct = skuProduct;
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.pict_product = pict_product;
        this.id_merchant = id_merchant;
    }

    public Product(String title, String description, String categories, String publication_year, Integer price, String author, String publisher, String isbn, String pict_product, Integer id_merchant) {
        this.title = title;
        this.description = description;
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.pict_product = pict_product;
        this.id_merchant = id_merchant;
    }

    public String getPict_product() {
        return pict_product;
    }

    public void setPict_product(String pict_product) {
        this.pict_product = pict_product;
    }
    public Product(){

    }

    public String getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(String skuProduct) {
        this.skuProduct = skuProduct;
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

    public Integer getId_merchant() {
        return id_merchant;
    }

    public void setId_merchant(Integer id_merchant) {
        this.id_merchant = id_merchant;
    }

    public String getBook_file() {
        return book_file;
    }

    public void setBook_file(String book_file) {
        this.book_file = book_file;
    }
}