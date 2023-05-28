package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Playbook;
import main.java.com.example.SquintV2.Models.Alarm;
import main.java.com.example.SquintV2.Repositories.PlaybookRepository;
import main.java.com.example.SquintV2.Repositories.AlarmRepository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaybookService {

    private final PlaybookRepository playbookRepository;
    private final AlarmRepository alarmRepository;


    @Autowired
    public PlaybookService(PlaybookRepository playbookRepository, AlarmRepository alarmRepository) {
      this.playbookRepository = playbookRepository;
      this.alarmRepository = alarmRepository;

    }

    public Playbook getPlaybookSettings(UUID userId) {
        Optional<Playbook> playbook = playbookRepository.findById(userId);
        return playbook.orElse(null);
            
    }

    public List<Alarm> getAlarmsForUser(UUID userId) {
        return alarmRepository.findByUserId(userId);
    }

    public Playbook updatePlaybookSettings(UUID userId, Playbook updatedSettings) {
        Playbook existingPlaybook = playbookRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Playbook settings not found for user: " + userId));

        // Update the individual settings
        existingPlaybook.setReminder(updatedSettings.getReminder());
        existingPlaybook.setReminderTime(updatedSettings.getReminderTime());
        existingPlaybook.setCheckCompletion(updatedSettings.getCheckCompletion());
        existingPlaybook.setAlarms(updatedSettings.getAlarms());
        existingPlaybook.setConflicts(updatedSettings.getConflicts());
        existingPlaybook.setReschedules(updatedSettings.getReschedules());

        return playbookRepository.save(existingPlaybook);
    }

    public Alarm updateAlarm(UUID alarmId, Alarm updatedAlarm) {
        Alarm existingAlarm = alarmRepository.findById(alarmId)
                .orElseThrow(() -> new RuntimeException("Alarm not found: " + alarmId));

        // Update the individual alarm properties
        existingAlarm.setAlarmTime(updatedAlarm.getAlarmTime());

        return alarmRepository.save(existingAlarm);
    }

}