package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="quote")
public class Quote {

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

    public void setQuote(String quote) {
        this.quote = quote;
    }

}