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

@Table(name="productivity")
public class Productivity{


    @Id
    private Integer productivity_id;

    @Column(name="user_id", nullable=false)
    private Integer user_id;

    @Column(name="date")
    private Date date;

    public Integer getProductivityId() {
        return this.productivity_id;
    }

    public void setProductivityId(Integer productivity_id) {
        this.productivity_id = productivity_id;
    }

    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }


    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}