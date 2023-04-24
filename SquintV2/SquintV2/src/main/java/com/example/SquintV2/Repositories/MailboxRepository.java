package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Mailbox;

public interface MailboxRepository extends CrudRepository<Mailbox, Integer> {
    
}