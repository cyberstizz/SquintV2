package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="quote")
public class Quote {

    @GeneratedValue
    @Id
    private Integer quote_id;

    @Column(name="quote_type")
    private String quote_type;

    @Column(name="text")
    private String quote;

    public String getQuoteType() {
        return this.quote_type;
    }

    public void setQuoteType(String quoteType) {
        this.quote_type = quoteType;
    }

    public String getQuote() {
        return this.quote;
    }

}