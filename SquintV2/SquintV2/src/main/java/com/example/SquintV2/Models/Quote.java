package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(value = "quote")
public class Quote {

    @Id
    @PrimaryKeyColumn(name = "quote_type", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String quote_type;
    
    @Id
    @PrimaryKeyColumn(name = "quote_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID quote_id;

    @Column(value = "quote_author")
    private String quote_author;

    @Column(value = "text")
    private String quote;

    public String getQuote_type() {
        return quote_type;
    }

    public void setQuote_type(String quote_type) {
        this.quote_type = quote_type;
    }

    public UUID getQuote_id() {
        return quote_id;
    }

    public void setQuote_id(UUID quote_id) {
        this.quote_id = quote_id;
    }

    public String getQuote_author() {
        return quote_author;
    }

    public void setQuote_author(String quote_author) {
        this.quote_author = quote_author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    
}






