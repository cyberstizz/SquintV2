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

    public UUID getBookId() {
        return this.book_id;
    }

    public void setBookId(UUID book_id) {
        this.book_id = book_id;
    }

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public Integer getTotalPages() {
        return this.total_pages;
    }

    public void setTotalPages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getCurrentPage() {
        return this.current_page;
    }

    public void setCurrentPage(Integer current_page) {
        this.current_page = current_page;
    }

    public LocalDate getCompletionDate() {
        return this.completion_date;
    }

}