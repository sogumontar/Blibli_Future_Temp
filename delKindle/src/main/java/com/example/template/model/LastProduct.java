package com.example.template.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="last_product")
public class LastProduct {

    @Id
    @Column(name = "last_book")
    public Integer last_book;

    @Column(name = "last_picture")
    public Integer last_picture;


    public Integer getLast_book() {
        return last_book;
    }

    public void setLast_book(Integer last_book) {
        this.last_book = last_book;
    }

    public Integer getLast_picture() {
        return last_picture;
    }

    public void setLast_picture(Integer last_picture) {
        this.last_picture = last_picture;
    }
}
