package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import main.java.com.example.SquintV2.Enums.Alarms;
import main.java.com.example.SquintV2.Enums.Check_completion;
import main.java.com.example.SquintV2.Enums.Conflicts;
import main.java.com.example.SquintV2.Enums.Reminder;
import main.java.com.example.SquintV2.Enums.Reschedules;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name="alarm")
public class Alarm {


    @GeneratedValue
    @Id
    private Integer alarm_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user_id;

    @Column(name = "alarm_time")
    private Date alarm_time;


}   
