package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(name="quote")
public class Quote {

    @Id
    @PrimaryKeyColumn(name = "quote_type", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String quote_type;

    @Column(name="quote_author")
    private String quote_author;

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