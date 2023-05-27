package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Playbook;
import main.java.com.example.SquintV2.Services.PlaybookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/playbook")
public class PlaybookController {

    private final PlaybookService playbookService;


    @Autowired
    public PlaybookController(PlaybookService playbookService) {
        this.playbookService = playbookService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Playbook> getPlaybookSettings(@PathVariable UUID userId) {
        Playbook playbook = playbookService.getPlaybookSettings(userId);
        if (playbook != null) {
            return ResponseEntity.ok(playbook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}