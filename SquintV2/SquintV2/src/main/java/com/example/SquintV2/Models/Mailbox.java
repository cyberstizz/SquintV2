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
    private Integer message_id;

    @Column(name="user_id", nullable= false)
    private Integer sender_id;

    @Column(name="user_id", nullable= false)
    private Integer recipient_id;

    @Column(name="header")
    private String header;

    @Column(name="body")
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