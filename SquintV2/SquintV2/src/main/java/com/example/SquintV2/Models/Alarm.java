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
@Table(name="alarm")
public class Alarm {

    @GeneratedValue
    @Id
    private Integer alarm_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Integer user_id;

    @Column(name = "alarm_time")
    private Date alarm_time;

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

    public Date getAlarmTime() {
        return this.alarm_time;
    }

    public void setAlarmTime(Date alarm_time) {
        this.alarm_time = alarm_time;
    }


}   
