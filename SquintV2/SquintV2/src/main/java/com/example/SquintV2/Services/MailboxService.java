package com.example.SquintV2.Services;

import com.example.SquintV2.Models.Mailbox;
import com.example.SquintV2.Repositories.MailboxRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MailboxService {

    private final MailboxRepository mailboxRepository;


    @Autowired
    public MailboxService(MailboxRepository mailboxRepository) {
        this.mailboxRepository = mailboxRepository;
    }

    public List<Mailbox> getMessages(UUID recipientId) {
        return mailboxRepository.findTop10ByRecipientIdOrderByDateDesc(recipientId);
    }

    public Optional<Mailbox> getMessage(UUID messageId) {
        return mailboxRepository.findById(messageId);
    }

    public Mailbox sendMessage(Mailbox message) {
        return mailboxRepository.save(message);
    }



    public void deleteMessage(UUID messageId, UUID userId) {
        Optional<Mailbox> mailboxOptional = mailboxRepository.findById(messageId);
        if (mailboxOptional.isPresent()) {
            Mailbox mailbox = mailboxOptional.get();
            UUID recipientId = mailbox.getRecipient_id();
            UUID senderId = mailbox.getSender_id();
            String deletedByRecipient = "deleted_by_recipient";
            String deletedBySender = "deleted_by_sender";


               //this code will delete the message if the status is deletedbysender and the recipient is the
                //one whom initiated this function.
                if (mailbox.getStatus().equals(deletedBySender) && recipientId.equals(userId)) {
                    mailboxRepository.deleteById(messageId);
                }
    
                if (mailbox.getStatus().equals(deletedByRecipient) && senderId.equals(userId)) {
                    mailboxRepository.deleteById(messageId);        
                }
    
            if (recipientId.equals(userId)) {
                mailbox.setStatus(deletedByRecipient);
                mailboxRepository.save(mailbox);
            } else if (senderId.equals(userId)) {
                mailbox.setStatus(deletedBySender);
                mailboxRepository.save(mailbox);
            }
    
             
        }
    }

}
    
    
    
    
    
    
    
    
    
   