package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;



@Table(name="alarm")
public class Alarm {

    @Id
    private Integer alarm_id;

    @Column(name="user_id", nullable = false)
    private Integer user_id;

    @Column(name = "alarm_time")
    private LocalDate alarm_time;

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getAlarmTime() {
        return this.alarm_time;
    }

    public void setAlarmTime(LocalDate alarm_time) {
        this.alarm_time = alarm_time;
    }


}   
