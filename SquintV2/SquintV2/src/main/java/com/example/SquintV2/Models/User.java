package main.java.com.example.SquintV2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="user")
public class Users {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password_hash")
    private String password_hash;
}