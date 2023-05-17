package com.example.SquintV2.Models;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.metamodel.PrimaryKey;
import jakarta.persistence.metamodel.PrimaryKeyType;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.core.type.codec.TypeCodecs;

@Table(name="books")
public class Books{


    @Id 
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = primaryKeyType.PARTITIONED)
    private UUID user_id;
    
    @Id @PrimaryKeyColumn(name = "book_id", ordinal = 1, type = primaryKeyType.CLUSTERED)
    private UUID book_id;

    @Column("book_title")
    @CassandraType(type = Text)
    private String book_title;

    @Column(name="author")
    @CassandraType(type = Text)
    private String author;

    @Column(name="total_pages")
    @CassandraType(type = Integer)
    private Integer total_pages;

    @Column(name="current_page")
    @CassandraType(type = Integer)
    private Integer current_page;

    @Column(name="completion_date")
    @CassandraType(type = LocalDate)
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