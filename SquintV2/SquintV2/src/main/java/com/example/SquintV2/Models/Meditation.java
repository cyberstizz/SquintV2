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

    @Column(name="current_streak")
    private Integer current_streak;

    @Column(name="longest_streak")
    private Integer longest_streak;

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public String getTotalTime() {
        return this.total_time;
    }

    public void setTotalTime(String total_time) {
        this.total_time = total_time;
    }

    public Integer getCurrentStreak() {
        return this.current_streak;
    }

    public void setCurrentStreak(Integer current_streak) {
        this.current_streak = current_streak;
    }

}