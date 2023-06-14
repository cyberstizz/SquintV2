package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Mailbox;
import main.java.com.example.SquintV2.Services.MailboxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/mailbox")
public class MailboxController {
    private final MailboxService mailboxService;

    @Autowired
    public MailboxController(MailboxService mailboxService) {
        this.mailboxService = mailboxService;
    }

    @GetMapping("/messages/{recipientId}")
    public ResponseEntity<List<String>> getMessages(@PathVariable UUID recipientId) {
        List<String> messages = mailboxService.getMessages(recipientId);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/message/{messageId}")
    public ResponseEntity<Mailbox> getMessage(@PathVariable UUID messageId) {
        Optional<Mailbox> message = mailboxService.getMessage(messageId);
        return message.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/send")
    public ResponseEntity<Mailbox> sendMessage(@RequestBody Mailbox message) {
        Mailbox sentMessage = mailboxService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(sentMessage);
    }

    @DeleteMapping("/message/{messageId}/user/{userId}")
    public ResponseEntity<String> deleteMessage(@PathVariable UUID messageId, @PathVariable UUID userId) {
        mailboxService.deleteMessage(messageId, userId);
        return ResponseEntity.ok("Message deleted successfully");
    }

    
}

    