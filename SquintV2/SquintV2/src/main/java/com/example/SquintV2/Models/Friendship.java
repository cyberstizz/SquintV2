package main.java.com.example.SquintV2.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="friendship")
public class Friendship{


    @GeneratedValue
    @Id
    private Integer friendship_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User user_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User friend_id;

    @Column(name="status")
    private String status;

    public Integer getFriendship_id() {
        return this.friendship_id;
    }

    public void setFriendship_id(Integer friendship_id) {
        this.friendship_id = friendship_id;
    }


    public User getUserId() {
        return this.user_id;
    }

    public void setUserId(User user_id) {
        this.user_id = user_id;
    }

    public User getFriendId() {
        return this.friend_id;
    }

    public void setFriendId() {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return this.status;
    }

}