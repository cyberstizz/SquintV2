package main.java.com.example.SquintV2.Services;


import main.java.com.example.SquintV2.Models.Meditation;
import main.java.com.example.SquintV2.Models.Quote;
import main.java.com.example.SquintV2.Repositories.MeditationRepository;
import main.java.com.example.SquintV2.Repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MeditationService {

    private final MeditationRepository meditationRepository;
    private final QuoteRepository quoteRepository;

    @Autowired
    public MeditationService(MeditationRepository meditationRepository, QuoteRepository quoteRepository) {
        this.meditationRepository = meditationRepository;
        this.quoteRepository = quoteRepository;
    }

    public Meditation getUsersInfo(UUID userId) {
        Optional<Meditation> meditationOptional = meditationRepository.findById(userId);
        return meditationOptional.orElse(null);
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int randomIndex = (int) (Math.random() * quotes.size());
        return quotes.get(randomIndex);
    }

}