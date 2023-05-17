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

@Table(name="friendship")
public class Friendship{



    @Id
    private Integer friendship_id;

    @ID
    @PrimaryKeyColumn
    private UUID user_id;

    @ID
    @PrimaryKeyColumn
    private UUID friend_id;

    @Column(name="status")
    private String status;

    public Integer getFriendship_id() {
        return this.friendship_id;
    }

    public void setFriendship_id(Integer friendship_id) {
        this.friendship_id = friendship_id;
    }


    public UUID getUserId() {
        return this.user_id;
    }

    public void setUserId(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getFriendId() {
        return this.friend_id;
    }

    public void setFriendId() {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}