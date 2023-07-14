package com.example.SquintV2.Controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.example.SquintV2.Models.Affirmation;
import com.example.SquintV2.Services.AffirmationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;


import java.util.UUID;

@Controller
public class AffirmationController {

    private final AffirmationsService affirmationsService;


    @Autowired
    public AffirmationController(AffirmationsService affirmationsService) {
        this.affirmationsService = affirmationsService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Affirmation> getAffirmation(@PathVariable UUID userId) {
        Affirmation affirmation = affirmationsService.getAffirmation(userId);
        return ResponseEntity.ok(affirmation);
    }


    @PostMapping
    public ResponseEntity<Affirmation> createAffirmation(@RequestBody Affirmation affirmation) {
        Affirmation createdAffirmation = affirmationsService.createAffirmation(affirmation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAffirmation);
    }


    @PutMapping("/{affirmationId}")
    public ResponseEntity<Affirmation> updateAffirmation(@PathVariable UUID affirmationId, @RequestBody Affirmation updatedAffirmation) {
        Affirmation affirmation = affirmationsService.updateAffirmation(affirmationId, updatedAffirmation);
        return ResponseEntity.ok(affirmation);
    }


    @DeleteMapping("/{affirmationId}")
    public ResponseEntity<?> deleteAffirmation(@PathVariable UUID affirmationId) {
        affirmationsService.deleteAffirmation(affirmationId);
        return ResponseEntity.noContent().build();
    }

}