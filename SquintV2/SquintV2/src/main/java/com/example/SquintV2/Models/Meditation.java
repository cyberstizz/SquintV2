package com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;



@Table(value = "meditation")
public class Meditation{

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column(value = "total_sessions")
    private Integer total_sessions;
    
    @Column(value = "total_time")
    private Integer total_time;

    @Column(value = "current_streak")
    private Integer current_streak;

    @Column(value = "longest_streak")
    private Integer longest_streak;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public Integer getTotal_sessions() {
        return total_sessions;
    }

    public void setTotal_sessions(Integer total_sessions) {
        this.total_sessions = total_sessions;
    }

    public Integer getTotal_time() {
        return total_time;
    }

    public void setTotal_time(Integer total_time) {
        this.total_time = total_time;
    }

    public Integer getCurrent_streak() {
        return current_streak;
    }

    public void setCurrent_streak(Integer current_streak) {
        this.current_streak = current_streak;
    }

    public Integer getLongest_streak() {
        return longest_streak;
    }

    public void setLongest_streak(Integer longest_streak) {
        this.longest_streak = longest_streak;
    }


}