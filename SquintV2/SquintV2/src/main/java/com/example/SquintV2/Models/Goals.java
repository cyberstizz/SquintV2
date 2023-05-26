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
    private UUID user_id;

    @Id
    private UUID goal_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getGoalId() {
        return this.goal_id;
    }

    public void setGoalId(UUID goal_id) {
        this.goal_id = goal_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
 }