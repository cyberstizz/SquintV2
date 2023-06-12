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

}