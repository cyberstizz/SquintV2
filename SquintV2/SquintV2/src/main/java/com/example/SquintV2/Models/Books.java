package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Table(name="books")
public class Books{


    @GeneratedValue
    @Id
    private Integer book_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Integer user_id;

    @Column(name="pages")
    private Integer pages;

    @Column(name="current_page")
    private Integer current_page;

    @Column(name="completion_date")
    private Date completion_date;

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