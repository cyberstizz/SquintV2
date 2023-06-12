package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Meditation;
import main.java.com.example.SquintV2.Models.Quote;
import main.java.com.example.SquintV2.Services.MeditationService;
import main.java.com.example.SquintV2.Services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/meditation")
public class MeditationController {

    private final MeditationService meditationService;
    private final QuoteService quoteService;

    @Autowired
    public MeditationController(MeditationService meditationService, QuoteService quoteService) {
        this.meditationService = meditationService;
        this.quoteService = quoteService;
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

}