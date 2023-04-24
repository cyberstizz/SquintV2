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
@Table(name="daily_schedule")
public class DailySchedule {


    @GeneratedValue
    @Id
    private Integer schedule_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User user_id;

    @Column(name="time_block")
    private Array<Date> time_block;

    @Column(name="task")
    private String task;

    public User getUserId() {
        return this.user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

    public Date getTimeBlock() {
        return this.time_block;
    }

    public void setTimeBlock(Date time_block) {
        this.time_block = time_block;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}