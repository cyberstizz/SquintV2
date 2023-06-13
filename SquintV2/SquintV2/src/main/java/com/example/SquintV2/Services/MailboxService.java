package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Mailbox;
import main.java.com.example.SquintV2.Repositories.MailboxRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MailboxService {

    private final MailboxRepository mailboxRepository;


    @Autowired
    public MailboxService(MailboxRepository mailboxRepository) {
        this.mailboxRepository = mailboxRepository;
    }

}