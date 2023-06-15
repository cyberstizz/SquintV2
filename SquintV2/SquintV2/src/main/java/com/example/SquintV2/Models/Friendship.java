package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;




@Table(value="friendship")
public class Friendship{

    @Id
    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID user_id;

    @Id
    @PrimaryKeyColumn(name = "date", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private LocalDate date;
    
    @Column(value = "friendship_id")
    private UUID friendship_id;


    @Column(value = "friend_id")
    private UUID friend_id;

    @Column(value ="status")
    private String status;

    @Transient
    private Stats stats;

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getFriendship_id() {
        return friendship_id;
    }

    public void setFriendship_id(UUID friendship_id) {
        this.friendship_id = friendship_id;
    }

    public UUID getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(UUID friend_id) {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

}