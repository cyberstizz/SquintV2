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
@Table(name="mailbox")
public class Mailbox{

    @GeneratedValue
    @Id
    private Integer message_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User sender_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable= false)
    private User recipient_id;

    @Column(name="header")
    private String header;

    @Column(name="body")
    private String body;

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}