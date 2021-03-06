package com.example.template.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seq_user")
public class SeqUser {

    @Id
    @Column(name ="key")
    private String key;

    @Column(name ="last_seq")
    private String last_seq;

    public String getKey() {
        return key;
    }

    public SeqUser(){

    }

    public SeqUser(String key,String last_seq){
        this.key = key;
        this.last_seq = last_seq;
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
