package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(value = "affirmation")
public class Affirmation{

    @Id
    @PrimaryKeyColumn(name = "affirmation_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer affirmation_id;

    @Id 
    @PrimaryKeyColumn(name = "user_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private Integer user_id;

    public Integer getAffirmationId() {
        return this.affirmation_id;
    }

    public void setAffirmationId(Integer affirmation_id) {
        this.affirmation_id = affirmation_id;
    }


    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

}