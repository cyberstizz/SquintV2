package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Table(name="meditation")
public class Meditation{

    @Column(name="user_id", nullable=false)
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

    public Integer getLongestStreak() {
        return this.longest_streak;
    }

    public void setLongestStreak(Integer longest_streak) {
        this.longest_streak = longest_streak;
    }

}