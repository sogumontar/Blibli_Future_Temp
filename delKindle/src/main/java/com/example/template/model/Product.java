package com.example.template.model;

<<<<<<< HEAD
import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "pictProduct")
    private String pictProduct;

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


    public Product(){

    }
    public Product(long id, String title, String description, String pictProduct, String categories, String publication_year, long price, String author, String publisher, String isbn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pictProduct = pictProduct;
=======
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

    public Product(String title, String description, String categories, String publication_year, Integer price, String author, String publisher , String isbn) {
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
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
        this.categories = categories;
        this.publication_year = publication_year;
        this.price = price;
        this.author = author;
<<<<<<< HEAD
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
=======
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
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
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

<<<<<<< HEAD
    public String getPictProduct() {
        return pictProduct;
    }

    public void setPictProduct(String pictProduct) {
        this.pictProduct = pictProduct;
    }

=======
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
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

<<<<<<< HEAD
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
=======
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

<<<<<<< HEAD
=======
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

<<<<<<< HEAD
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
=======
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
>>>>>>> 02a0c9ac486e3a4ae7c25ea74e379b9f48e2a147
    }
}
