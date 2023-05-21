package com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
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

    @Column(name="current_page")
    private Integer current_page;

    @Column(name="completion_date")
    private LocalDate completion_date;

    public Integer getBookId() {
        return this.book_id;
    }

    public void setBookId(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getCurrentPage() {
        return this.current_page;
    }

    public void setCurrentPage(Integer current_page) {
        this.current_page = current_page;
    }

    public Date getCompletionDate() {
        return this.completion_date;
    }

}