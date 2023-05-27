package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(value="photo")
public class Photo{

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id
    @PrimaryKeyColumn(name = "deadline", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDate deadline;
    
    @Column(value = "photo_id")
    private UUID photo_id;

    @Column(value ="path_or_url")
    private String path_or_url;

    @Column(value ="goal_id")
    private UUID goal_id;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public UUID getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(UUID photo_id) {
        this.photo_id = photo_id;
    }

    public String getPath_or_url() {
        return path_or_url;
    }

    public void setPath_or_url(String path_or_url) {
        this.path_or_url = path_or_url;
    }

    public UUID getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(UUID goal_id) {
        this.goal_id = goal_id;
    }

    


}