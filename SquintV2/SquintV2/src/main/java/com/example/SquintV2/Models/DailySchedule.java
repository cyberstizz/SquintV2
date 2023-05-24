package main.java.com.example.SquintV2.Models;

import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;



@Table(value="dailySchedule")
public class Task {



    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id
    @PrimaryKeyColumn(name = "time_block", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private List<LocalDate> time_block;
   

    @Column(value = "schedule_id")
    private UUID schedule_id;

    @Column(value ="task")
    private String task;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public List<LocalDate> getTimeBlock() {
        return this.time_block;
    }

    public void setTimeBlock(List<LocalDate> time_block) {
        this.time_block = time_block;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}