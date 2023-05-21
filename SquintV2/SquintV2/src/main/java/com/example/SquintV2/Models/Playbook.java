package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Id;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;




import main.java.com.example.SquintV2.Enums.Alarms;
import main.java.com.example.SquintV2.Enums.Check_completion;
import main.java.com.example.SquintV2.Enums.Conflicts;
import main.java.com.example.SquintV2.Enums.Reminder;
import main.java.com.example.SquintV2.Enums.ReminderTime;
import main.java.com.example.SquintV2.Enums.Reschedules;



@Table(value ="playbook")
public class Playbook {

    @Id @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = primaryKeyType.PARTITIONED)
    private UUID user_id;

    @Column("reminders")
    @CassandraType(type = Reminder)
    private Reminder reminders;

    @Column("reminder_time")
    @CassandraType(type = ReminderTime)
    private ReminderTime reminder_time;

    @Column("check_completion")
    @CassandraType(type = Check_completion)
    private Check_completion check_completion;

    @Column("alarm_types")
    @CassandraType(type = Alarms)
    private Alarms alarm_types;

    @Column("conflicts")
    @CassandraType(type = Conflicts)
    private Conflicts conflicts;

    @Column("reschedules")
    @CassandraType(type = Reschedules)
    private Reschedules reschedules;

    public Reminder getReminder() {
        return this.reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public ReminderTime getReminderTime() {
        return this.reminder_time;
    }

    public void setReminderTime(LocalDate reminder_time) {
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