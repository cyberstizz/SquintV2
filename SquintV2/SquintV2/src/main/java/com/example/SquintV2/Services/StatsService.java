package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Stats;
import main.java.com.example.SquintV2.Repositories.StatsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StatsService {

    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }


    public Optional<Stats> getStatsForCurrentDay(UUID userId) {
        LocalDate currentDate = LocalDate.now();
        return statsRepository.findByUserIdAndDate(userId, currentDate);
    }


    public List<Stats> getStatsForCurrentWeek(UUID userId) {
        LocalDate currentDate = LocalDate.now();
        LocalDate weekStartDate = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1);
        return statsRepository.findByUserIdAndDateBetween(userId, weekStartDate, currentDate);
    }

}