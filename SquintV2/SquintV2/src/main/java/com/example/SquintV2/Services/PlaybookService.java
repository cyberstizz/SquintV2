package com.example.SquintV2.Services;

import com.example.SquintV2.Models.Playbook;
import com.example.SquintV2.Models.Alarm;
import com.example.SquintV2.Repositories.PlaybookRepository;
import com.example.SquintV2.Repositories.AlarmRepository;

import java.util.List;
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
        //grabs all of the playbook setttings for a specified user
    public Playbook getPlaybookSettings(UUID userId) {
        Optional<Playbook> playbook = playbookRepository.findById(userId);
        return playbook.orElse(null);
            
    }
        //grabs all of the alarms for a specified user
    public List<Alarm> getAlarmsForUser(UUID user_Id) {
        return alarmRepository.findByUserId(user_Id);
    }
        //updates the playbook settings for a specified user
    public Playbook updatePlaybookSettings(UUID userId, Playbook updatedSettings) {
        Playbook existingPlaybook = playbookRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Playbook settings not found for user: " + userId));

        // Update the individual settings
        existingPlaybook.setReminders(updatedSettings.getReminders());
        existingPlaybook.setReminder_time(updatedSettings.getReminder_time());
        existingPlaybook.setCheck_completion(updatedSettings.getCheck_completion());
        existingPlaybook.setAlarm_types(updatedSettings.getAlarm_types());
        existingPlaybook.setConflicts(updatedSettings.getConflicts());
        existingPlaybook.setReschedules(updatedSettings.getReschedules());

        return playbookRepository.save(existingPlaybook);
    }
        //updates the alarm for a specified user
    public Alarm updateAlarm(UUID alarmId, Alarm updatedAlarm) {
        Alarm existingAlarm = alarmRepository.findById(alarmId)
                .orElseThrow(() -> new RuntimeException("Alarm not found: " + alarmId));

        // Update the individual alarm properties
        existingAlarm.setAlarmTime(updatedAlarm.getAlarmTime());

        return alarmRepository.save(existingAlarm);
    }

        //create an intial playbook with settings
    public Playbook createPlaybookSettings(UUID userId, Playbook playbook) {
        playbook.setUser_id(userId);
        return playbookRepository.save(playbook);
    }
        //creates a new alarm for a user
    public Alarm createAlarm(UUID userId, Alarm alarm) {
        alarm.setUserId(userId);
        return alarmRepository.save(alarm);
    }

}