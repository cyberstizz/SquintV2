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
@Table(name="affirmation")
public class Affirmation{

    @GeneratedValue
    @Id
    private Integer affirmation_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
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