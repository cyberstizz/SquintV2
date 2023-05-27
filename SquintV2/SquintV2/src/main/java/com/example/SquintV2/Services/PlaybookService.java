package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Playbook;
import main.java.com.example.SquintV2.Repositories.PlaybookRepository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaybookService {

    private final PlaybookRepository playbookRepository;

    @Autowired
    public PlaybookService(PlaybookRepository playbookRepository) {
        this.playbookRepository = playbookRepository;
    }

    public Playbook getPlaybookSettings(UUID userId) {
        return playbookRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Playbook settings not found for user: " + userId));
    }

}