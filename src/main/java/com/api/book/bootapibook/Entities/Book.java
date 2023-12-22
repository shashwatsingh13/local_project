package com.api.book.bootapibook.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "authur")
    private String authur;

    public Book(int id, String title, String authur) {
        this.id = id;
        this.title = title;
        this.authur = authur;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthur() {
        return authur;
    }

    public void setAuthur(String authur) {
        this.authur = authur;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authur=" + authur + "]";
    }
    
}
