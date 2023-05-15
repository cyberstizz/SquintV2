package main.java.com.example.SquintV2.Models;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="Goals")
public class Goals {


    @Id @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = primaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id@PrimaryKeyColumn(name = "goal_id", ordinal = 0, type = primaryKeyType.CLUSTERED)
    private Integer goal_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private Date deadline;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
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

    public Date getDeadline() {
        return this.deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
 }