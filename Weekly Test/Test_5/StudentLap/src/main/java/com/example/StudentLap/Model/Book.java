package com.example.StudentLap.Model;

import jakarta.persistence.*;
@Entity
@Table(name="book_tbl")
public class Book {
    @Id
    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;

    @ManyToOne
    private Student student;
}
