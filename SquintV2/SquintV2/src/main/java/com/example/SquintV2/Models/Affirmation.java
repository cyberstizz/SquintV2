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


@Table(name="affirmation")
public class Affirmation{

    @Id
    @PrimaryKey
    private Integer affirmation_id;

    @Column(name="user_id", nullable=false)
    private Integer user_id;

    public Integer getAffirmationId() {
        return this.affirmation_id;
    }

    public void setAffirmationId(Integer affirmation_id) {
        this.affirmation_id = affirmation_id;
    }


    public Integer getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

}