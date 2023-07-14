package com.example.SquintV2.Controllers;

import com.example.SquintV2.Models.Meditation;
import com.example.SquintV2.Models.Quote;
import com.example.SquintV2.Services.MeditationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/meditation")
public class MeditationController {

    private final MeditationService meditationService;

    @Autowired
    public MeditationController(MeditationService meditationService) {
        this.meditationService = meditationService;
    }


    @GetMapping("/dashboard/{userId}")
    public DashboardData showDashboard(@PathVariable UUID userId) {
        Meditation meditation = meditationService.getUsersInfo(userId);
        Quote quote = meditationService.getRandomQuote();
        return new DashboardData(meditation, quote);
    }


    @PostMapping("/add/{userId}")
    public Meditation addMeditation(@PathVariable UUID userId, @RequestBody Meditation newMeditation) {
        return meditationService.addMeditation(userId, newMeditation);
    }


    private static class DashboardData {
        private final Meditation meditation;
        private final Quote quote;

        public DashboardData(Meditation meditation, Quote quote) {
            this.meditation = meditation;
            this.quote = quote;
        }

        public Meditation getMeditation() {
            return meditation;
        }

        public Quote getQuote() {
            return quote;
        }
    }

}