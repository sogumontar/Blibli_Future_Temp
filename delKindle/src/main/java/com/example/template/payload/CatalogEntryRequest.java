package com.example.template.payload;

public class CatalogEntryRequest {
    public String gambar;
    public String sku_product;
    public String bookFile;
    public String title;

    public String description;

    public String categories;

    public String publication_year;

    public String author;

    public String publisher;

    public String isbn;

    public String pict_product;

    public String book_file;

    public Integer price;

    public String sku_merchant;

    public String name_merchant;

    public String getBookFile() {
        return bookFile;
    }

    public void setBookFile(String bookFile) {
        this.bookFile = bookFile;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getSku_product() {
        return sku_product;
    }

    public void setSku_product(String sku_product) {
        this.sku_product = sku_product;
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

    public String getPict_product() {
        return pict_product;
    }

    public void setPict_product(String pict_product) {
        this.pict_product = pict_product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBook_file() {
        return book_file;
    }

    public void setBook_file(String book_file) {
        this.book_file = book_file;
    }

    public String getSku_merchant() {
        return sku_merchant;
    }

    public void setSku_merchant(String sku_merchant) {
        this.sku_merchant = sku_merchant;
    }

    public String getName_merchant() {
        return name_merchant;
    }

    public void setName_merchant(String name_merchant) {
        this.name_merchant = name_merchant;
    }
}
