package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="book")
public class Book{


    @GeneratedValue
    @Id
    private Integer book_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Integer user_id;

}