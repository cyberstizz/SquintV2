package main.java.com.example.SquintV2.Models;

import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;




@Table(value="Tasks")
public class Tasks {

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @PrimaryKeyColumn(name = "schedule_item", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDate task_deadline;

    @Column(value ="task_id")
    private UUID task_id;
    
    @Column(value ="task_name")
    private String task_name;

    @Column(value ="task_description")
    private String task_description;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getTask_deadline() {
        return task_deadline;
    }

    public void setTask_deadline(LocalDate task_deadline) {
        this.task_deadline = task_deadline;
    }

    public UUID getTasl_id() {
        return task_id;
    }

    public void setTask_id(UUID task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    

    
}