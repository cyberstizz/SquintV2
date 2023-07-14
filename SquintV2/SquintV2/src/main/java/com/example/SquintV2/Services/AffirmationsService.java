package com.example.SquintV2.Services;

import com.example.SquintV2.Models.Affirmation;
import com.example.SquintV2.Repositories.AffirmationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public void deleteAffirmation(UUID affirmationId) {
        affirmationRepository.deleteById(affirmationId);
    }


}