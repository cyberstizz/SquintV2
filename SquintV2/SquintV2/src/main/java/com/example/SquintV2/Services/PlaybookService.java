package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Playbook;
import main.java.com.example.SquintV2.Repositories.PlaybookRepository;
import main.java.com.example.SquintV2.Exceptions.NotFoundException;

import java.util.Optional;
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
        Optional<Playbook> playbook = playbookRepository.findById(userId);
        return playbook.orElse(null);
            
    }

}