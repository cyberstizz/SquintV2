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

@Table(name="photo")
public class Photo{


    @Id
    private Integer photo_id;

    @Column(name="user_id", nullable=false)
    private UUID user_id;

    @Column(name="path_or_url")
    private String path_or_url;

    @ManyToOne
    @JoinColumn(name="goal_id", nullable=true)
    private Integer goal_id;

    public Integer getPhotoId() {
        return this.photo_id;
    }

    public void setInteger(Integer photo_id) {
        this.photo_id = photo_id;
    }

    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public String getPathOrUrl() {
        return this.path_or_url;
    }

    public void setPathOrUrl(String path_or_url) {
        this.path_or_url = path_or_url;
    }

    public Integer getGoalId() {
        return this.goal_id;
    }

    public void setGoalId(Integer goal_id) {
        this.goal_id = goal_id;
    }


}