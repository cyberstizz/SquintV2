package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.metamodel.PrimaryKey;
import jakarta.persistence.metamodel.PrimaryKeyType;
import com.datastax.oss.driver.api.core.type.DataTypes;
import com.datastax.oss.driver.api.core.type.codec.TypeCodecs;



@Table(name="alarm")
public class Alarm {

    @Id
    private Integer alarm_id;

    @Column(name="user_id", nullable = false)
    private Integer user_id;

    @Column(name = "alarm_time")
    private Date alarm_time;

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public Date getAlarmTime() {
        return this.alarm_time;
    }

    public void setAlarmTime(Date alarm_time) {
        this.alarm_time = alarm_time;
    }


}   
