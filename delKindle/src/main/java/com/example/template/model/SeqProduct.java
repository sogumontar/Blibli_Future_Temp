package com.example.template.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seq_product")
public class SeqProduct {
    @Id
    @Column(name = "key")
    public String key;

    @Column(name = "last_seq")
    public String last_seq;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLast_seq() {
        return last_seq;
    }

    public void setLast_seq(String last_seq) {
        this.last_seq = last_seq;
    }
}
