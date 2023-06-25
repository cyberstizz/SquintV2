package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Mailbox;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface MailboxRepository extends CassandraRepository<Mailbox, UUID>{
    List<Mailbox> findTop10ByRecipientIdOrderByDateDesc(UUID recipientId);
}

