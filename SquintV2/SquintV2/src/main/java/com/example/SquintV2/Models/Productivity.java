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
@Table(name="productivity")
public class Productivity{


    @GeneratedValue
    @Id
    private Integer productivity_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user_id;

    @Column(name="date")
    private Date date;

    public Integer getProductivityId() {
        return this.productivity_id;
    }

    public void setProductivityId(Integer productivity_id) {
        this.productivity_id = productivity_id;
    }

    public User getUserId() {
        return this.user_id;
    }

    public void setUserId(User user) {
        this.user_id = user_id;
    }


    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}