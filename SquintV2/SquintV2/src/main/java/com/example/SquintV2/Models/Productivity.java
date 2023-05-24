package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

import java.math.BigDecimal;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;


@Table(name="productivity")
public class Productivity{


    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id
    @PrimaryKeyColumn(name = "date", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDate date;

    @Column(value = "score")
    private BigDecimal score;

    @Column(value = "tasks_completed")
    private BigDecimal tasks_completed;

    @Column(value = "time_management")
    private BigDecimal time_management;

    @Column(value = "Report_completed")
    private Boolean Report_completed;

    @Column(value = "Productivity")
    private BigDecimal Productivity;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public BigDecimal getTasks_completed() {
        return tasks_completed;
    }

    public void setTasks_completed(BigDecimal tasks_completed) {
        this.tasks_completed = tasks_completed;
    }

    public BigDecimal getTime_management() {
        return time_management;
    }

    public void setTime_management(BigDecimal time_management) {
        this.time_management = time_management;
    }

    public Boolean getReport_completed() {
        return Report_completed;
    }

    public void setReport_completed(Boolean report_completed) {
        Report_completed = report_completed;
    }

    public BigDecimal getProductivity() {
        return Productivity;
    }

    public void setProductivity(BigDecimal productivity) {
        Productivity = productivity;
    }

    

    

}