package main.java.com.example.SquintV2.Models;

import java.util.List;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table(name="Goals")
public class Goals {


    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id
    @PrimaryKeyColumn(name = "goal_deadline", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDate goal_deadline;

    @Column(value = "goal_id")
    private UUID goal_id;
    
    @Column(value = "goal_name")
    private String goal_name;

    @Column(value = "goal_description")
    private String goal_description;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getGoal_deadline() {
        return goal_deadline;
    }

    public void setGoal_deadline(LocalDate goal_deadline) {
        this.goal_deadline = goal_deadline;
    }

    public UUID getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(UUID goal_id) {
        this.goal_id = goal_id;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    public String getGoal_description() {
        return goal_description;
    }

    public void setGoal_description(String goal_description) {
        this.goal_description = goal_description;
    }

    
 }