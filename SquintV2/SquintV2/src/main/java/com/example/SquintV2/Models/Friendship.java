package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;


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
    @PrimaryKeyColumn(name = "friendship_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID friendship_id;


    @Column(value = "friend_id")
    private UUID friend_id;

    @Column(value ="status")
    private String status;

    public UUID getFriendship_id() {
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

    public void setFriendId(UUID friend_id) {
        this.friend_id = friend_id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}