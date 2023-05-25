package main.java.com.example.SquintV2.Models;

import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;



@Table(value="daily_schedule_item")
public class DailyScheduleItem {



    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column(value = "schedule_item")
    private LocalDate schedule_item;

    @Column(value ="task_name")
    private String task_name;

    @Column(value ="task_description")
    private String task_description;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getTimeBlock() {
        return this.time_block;
    }

    public void setTimeBlock(LocalDate time_block) {
        this.time_block = time_block;
    }

    public String getTaskName() {
        return this.task_name;
    }

    public void setTaskName(String task_name) {
        this.task_name = task_name;
    }

}