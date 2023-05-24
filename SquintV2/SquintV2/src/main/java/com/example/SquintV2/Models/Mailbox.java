package main.java.com.example.SquintV2.Models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

@Table(name="mailbox")
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

    public Integer getMessageId() {
        return this.message_id;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}