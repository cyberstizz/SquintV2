package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Alarm;
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


    @PutMapping("/{userId}")
    public ResponseEntity<Playbook> updatePlaybookSettings(@PathVariable UUID userId, @RequestBody Playbook updatedSettings) {
        Playbook updatedPlaybook = playbookService.updatePlaybookSettings(userId, updatedSettings);
        return ResponseEntity.ok(updatedPlaybook);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Playbook> createPlaybookSettings(@PathVariable UUID userId, @RequestBody Playbook playbook) {
        Playbook createdPlaybook = playbookService.createPlaybookSettings(userId, playbook);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlaybook);


    @GetMapping("/{userId}/alarms")
    public ResponseEntity<List<Alarm>> getAlarmsForUser(@PathVariable UUID userId) {
        List<Alarm> alarms = playbookService.getAlarmsForUser(userId);
        if (!alarms.isEmpty()) {
            return ResponseEntity.ok(alarms);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @PutMapping("/alarms/{alarmId}")
    public ResponseEntity<Alarm> updateAlarm(@PathVariable UUID alarmId, @RequestBody Alarm updatedAlarm) {
        Alarm updatedAlarm = playbookService.updateAlarm(alarmId, updatedAlarm);
        return ResponseEntity.ok(updatedAlarm);
}

    @PostMapping("/{userId}/alarms")
    public ResponseEntity<Alarm> createAlarm(@PathVariable UUID userId, @RequestBody Alarm alarm) {
        Alarm createdAlarm = playbookService.createAlarm(userId, alarm);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAlarm);
}



}