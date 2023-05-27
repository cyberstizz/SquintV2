package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

@Table(value="mailbox")
public class Mailbox{

    @Id
    @PrimaryKeyColumn(name = "recipient_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID recipient_id;

    @Id
    @PrimaryKeyColumn(name = "sender_id", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private UUID sender_id;

    @Id
    @PrimaryKeyColumn(name = "date", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private LocalDate date;
    
    @Column(value = "message_id")
    private UUID message_id;

    @Column(value = "status")
    private String status;

    @Column(value = "header")
    private String header;
    
    @Column(value = "body")
    private String body;

    public UUID getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(UUID recipient_id) {
        this.recipient_id = recipient_id;
    }

    public UUID getSender_id() {
        return sender_id;
    }

    public void setSender_id(UUID sender_id) {
        this.sender_id = sender_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getMessage_id() {
        return message_id;
    }

    public void setMessage_id(UUID message_id) {
        this.message_id = message_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    

}