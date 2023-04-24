package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="meditation")
public class Meditation{

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Integer user_id;

    @Column(name="total_time")
    private String total_time;


}