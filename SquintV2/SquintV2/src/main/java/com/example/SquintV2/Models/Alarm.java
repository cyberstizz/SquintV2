package com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;


import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;




@Table(value="alarm")
public class Alarm {

    @Id
    @PrimaryKeyColumn(name = "alarm_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID alarm_id;

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID user_id;

    @Column(value = "alarm_time")
    private LocalDate alarm_time;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getAlarmTime() {
        return this.alarm_time;
    }

    public void setAlarmTime(LocalDate alarm_time) {
        this.alarm_time = alarm_time;
    }


}   
