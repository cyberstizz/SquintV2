package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;




import main.java.com.example.SquintV2.Enums.Alarms;
import main.java.com.example.SquintV2.Enums.CheckCompletion;
import main.java.com.example.SquintV2.Enums.Conflicts;
import main.java.com.example.SquintV2.Enums.Reminder;
import main.java.com.example.SquintV2.Enums.ReminderTime;
import main.java.com.example.SquintV2.Enums.Reschedules;



@Table(value ="playbook")
public class Playbook {

    @Id 
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column(value = "reminders")
    private Reminder reminders;

    @Column(value = "reminder_time")
    private ReminderTime reminder_time;

    @Column(value = "check_completion")
    private CheckCompletion check_completion;

    @Column(value = "alarm_types")
    private Alarms alarm_types;

    @Column(value = "conflicts")
    private Conflicts conflicts;

    @Column(value = "reschedules")
    private Reschedules reschedules;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public Reminder getReminders() {
        return reminders;
    }

    public void setReminders(Reminder reminders) {
        this.reminders = reminders;
    }

    public ReminderTime getReminder_time() {
        return reminder_time;
    }

    public void setReminder_time(ReminderTime reminder_time) {
        this.reminder_time = reminder_time;
    }

    public CheckCompletion getCheck_completion() {
        return check_completion;
    }

    public void setCheck_completion(CheckCompletion check_completion) {
        this.check_completion = check_completion;
    }

    public Alarms getAlarm_types() {
        return alarm_types;
    }

    public void setAlarm_types(Alarms alarm_types) {
        this.alarm_types = alarm_types;
    }

    public Conflicts getConflicts() {
        return conflicts;
    }

    public void setConflicts(Conflicts conflicts) {
        this.conflicts = conflicts;
    }

    public Reschedules getReschedules() {
        return reschedules;
    }

    public void setReschedules(Reschedules reschedules) {
        this.reschedules = reschedules;
    }

    
}