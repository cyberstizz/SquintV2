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

    public Void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return this.password_hash;
    }

    public Void setPasswordHash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return this.email;
    }

    public Void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAccessible() {
        return this.accessible;
    }

    public Void setAccessible(Boolean accessible) {
        this.accessible = accessible;
    }
}