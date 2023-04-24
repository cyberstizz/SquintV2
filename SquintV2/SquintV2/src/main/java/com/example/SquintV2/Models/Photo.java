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
@Table(name="photo")
public class Photo{


    @GeneratedValue
    @Id
    private Integer photo_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user_id;

    @Column(name="path_or_url")
    private String path_or_url;

    @ManyToOne
    @JoinColumn(name="goal_id", nullable=true)
    private Integer goal_id;

    public Integer getPhotoId() {
        return this.photo_id;
    }

    public void setInteger(Integer photo_id) {
        this.photo_id = photo_id;
    }

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
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


}