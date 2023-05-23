package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(name="books_read")
public class BooksRead{

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column(value = "books_read")
    private Integer books_read;
 

}