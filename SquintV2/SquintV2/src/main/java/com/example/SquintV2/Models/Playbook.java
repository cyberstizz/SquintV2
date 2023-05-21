package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;

import jakarta.persistence.Id;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;




import main.java.com.example.SquintV2.Enums.Alarms;
import main.java.com.example.SquintV2.Enums.Check_completion;
import main.java.com.example.SquintV2.Enums.Conflicts;
import main.java.com.example.SquintV2.Enums.Reminder;
import main.java.com.example.SquintV2.Enums.ReminderTime;
import main.java.com.example.SquintV2.Enums.Reschedules;



@Table(value ="playbook")
public class Playbook {

    @Id @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column("reminders")
    private Reminder reminders;

    @Column("reminder_time")
    private ReminderTime reminder_time;

    @Column("check_completion")
    private Check_completion check_completion;

    @Column("alarm_types")
    private Alarms alarm_types;

    @Column("conflicts")
    private Conflicts conflicts;

    @Column("reschedules")
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

    public Check_completion getCheckCompletioin() {
        return this.check_completion;
    }

    public void setCheckCompletion(Check_completion check_completion) {
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