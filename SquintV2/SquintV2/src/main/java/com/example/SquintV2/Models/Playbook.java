package main.java.com.example.SquintV2.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name ="playbook")
public class Playbook {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}