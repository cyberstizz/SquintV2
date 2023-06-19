package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;



@Table(value ="books")
public class Books{


    @Id 
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;
    
    @Id @PrimaryKeyColumn(name = "book_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID book_id;

    @Column(value = "book_title")
    private String book_title;

    @Column(value="author")
    private String author;

    @Column(value="total_pages")
    private Integer total_pages;

    @Column(value ="current_page")
    private Integer current_page;

    @Column(value ="completion_date")
    private LocalDate completion_date;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getBook_id() {
        return book_id;
    }

    public void setBook_id(UUID book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public LocalDate getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(LocalDate completion_date) {
        this.completion_date = completion_date;
    }

    

}