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


@Table(name="dailySchedule")
public class DailySchedule {


    @Id @PrimaryKeyColumn()
    private Integer schedule_id;

    @Column(name="user_id", nullable= false)
    private UUID user_id;

    @Column(name="time_block")
    private Array<Date> time_block;

    @Column(name="task")
    private String task;

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

    public Date getTimeBlock() {
        return this.time_block;
    }

    public void setTimeBlock(Date time_block) {
        this.time_block = time_block;
    }

    public String getTask() {
        return this.task;
    }

    public void setTask(String task) {
        this.task = task;
    }

}