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
@Table(name="friendship")
public class Friendship{


    @GeneratedValue
    @Id
    private Integer friendship_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User user_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User friend_id;

}