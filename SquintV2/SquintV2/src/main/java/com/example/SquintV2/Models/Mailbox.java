package main.java.com.example.SquintV2.Models;

import java.time.LocalDate;
import java.util.UUID;

import org.w3c.dom.Text;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
        return this.messageId;
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