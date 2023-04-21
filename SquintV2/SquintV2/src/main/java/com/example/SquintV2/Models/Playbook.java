package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import main.java.com.example.SquintV2.Enums.Check_completion;
import main.java.com.example.SquintV2.Enums.Reminder;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name ="playbook")
public class Playbook {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="reminders")
    private Reminder reminders;

    @Column(name= "reminder_time")
    private Date reminder_time;

    @Column(name= "check_completion")
    private Check_completion check_completion;

}