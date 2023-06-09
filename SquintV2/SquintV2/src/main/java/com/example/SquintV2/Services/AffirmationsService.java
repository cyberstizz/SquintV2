package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Affirmation;
import main.java.com.example.SquintV2.Models.Tasks;
import main.java.com.example.SquintV2.Repositories.AffirmationRepository;
import main.java.com.example.SquintV2.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class AffirmationsService {

    private final AffirmationRepository affirmationRepository;

    @Autowired
    public AffirmationsService(AffirmationRepository affirmationRepository) {
        this.affirmationRepository = affirmationRepository;
    }


    public Affirmation getAffirmation(UUID userId) {
        return affirmationRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Affirmation not found for user: " + userId));
    }


    public Affirmation updateAffirmation(UUID affirmationId, Affirmation updatedAffirmation) {
        Affirmation existingAffirmation = affirmationRepository.findById(affirmationId)
                .orElseThrow(() -> new RuntimeException("Affirmation not found: " + affirmationId));

        // Update the individual attributes of existingAffirmation using updatedAffirmation
        existingAffirmation.setAffirmationId(updatedAffirmation.getAffirmationId());
        existingAffirmation.setUserId(updatedAffirmation.getUserId());

        return affirmationRepository.save(existingAffirmation);
    }

    public Affirmation createAffirmation(Affirmation affirmation) {
        return affirmationRepository.save(affirmation);
    }


}