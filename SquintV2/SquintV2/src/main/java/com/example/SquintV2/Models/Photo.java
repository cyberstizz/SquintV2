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
@Table(name="photo")
public class Photo{


    @GeneratedValue
    @Id
    private Integer photo_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user_id;

    @Column(name="path_or_url")
    private String path_or_url;


}