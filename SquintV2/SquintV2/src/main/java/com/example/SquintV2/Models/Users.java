package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name ="users")
public class Users {

    @Id
    private Integer user_id;

    @Column(name="username")
    private String username;

    @Column(name="password_hash")
    private String password_hash;

    @Column(name="email")
    private String email;

    @Column(name="accesible")
    private Boolean accessible;


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return this.password_hash;
    }

    public void setPasswordHash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAccessible() {
        return this.accessible;
    }

    public void setAccessible(Boolean accessible) {
        this.accessible = accessible;
    }
}