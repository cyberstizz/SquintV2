package com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;



@Table(value = "users")
public class Users {

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Integer user_id;

    @Column(value = "icon_path_or_url")
    private String icon_path_or_url;

    @Column(value = "username")
    private String username;

    @Column(value = "password_hash")
    private String password_hash;

    @Column(value = "email")
    private String email;

    @Column(value = "daily_schedule")
    private List<Tasks> dailySchedule;

    @Column(value = "biography")
    private String biography;

    @Column(value = "birthday")
    private LocalDate birthday;

    @Column(value = "accesible")
    private Boolean accessible;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getIcon_path_or_url() {
        return icon_path_or_url;
    }

    public void setIcon_path_or_url(String icon_path_or_url) {
        this.icon_path_or_url = icon_path_or_url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tasks> getDailySchedule() {
        return dailySchedule;
    }

    public void setDailySchedule(List<Tasks> dailySchedule) {
        this.dailySchedule = dailySchedule;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Boolean getAccessible() {
        return accessible;
    }

    public void setAccessible(Boolean accessible) {
        this.accessible = accessible;
    }


    
}