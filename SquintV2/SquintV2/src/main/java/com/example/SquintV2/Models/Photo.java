package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value="photo")
public class Photo{

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column(value = "photo_id")
    private UUID photo_id;

    @Column(value ="path_or_url")
    private String path_or_url;

    @Column(value ="goal_id")
    private Integer goal_id;

    public UUID getPhotoId() {
        return this.photo_id;
    }

    public void setInteger(UUID photo_id) {
        this.photo_id = photo_id;
    }

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public String getPathOrUrl() {
        return this.path_or_url;
    }

    public void setPathOrUrl(String path_or_url) {
        this.path_or_url = path_or_url;
    }

    public Integer getGoalId() {
        return this.goal_id;
    }

    public void setGoalId(Integer goal_id) {
        this.goal_id = goal_id;
    }


}