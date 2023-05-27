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

    public Reminder getReminder() {
        return this.reminders;
    }

    public void setReminder(Reminder reminders) {
        this.reminders = reminders;
    }

    public ReminderTime getReminderTime() {
        return this.reminder_time;
    }

    public void setReminderTime(ReminderTime reminder_time) {
        this.reminder_time = reminder_time;
    }

    public CheckCompletion getCheckCompletioin() {
        return this.check_completion;
    }

    public void setCheckCompletion(CheckCompletion check_completion) {
        this.check_completion = check_completion;
    }

    public Alarms getAlarmType() {
        return this.alarm_types;
    }

    public void setAlarmTypes(Alarms alarmTypes) {
        this.alarm_types = alarmTypes;
    }

    public Conflicts getConflicts() {
        return this.conflicts;
    }

    public void setConflicts(Conflicts conflicts) {
        this.conflicts = conflicts;
    }

    public Reschedules getReschedules() {
        return this.reschedules;
    }

    public void setReschedules(Reschedules reschedules) {
        this.reschedules = reschedules;
    }
}