package main.java.com.example.SquintV2.Controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import main.java.com.example.SquintV2.Models.Affirmation;
import main.java.com.example.SquintV2.Services.AffirmationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}