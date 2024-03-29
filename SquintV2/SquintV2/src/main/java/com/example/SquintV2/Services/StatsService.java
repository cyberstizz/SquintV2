package com.example.SquintV2.Services;

import com.example.SquintV2.Models.Stats;
import com.example.SquintV2.Repositories.StatsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    @SuppressWarnings("deprecation")
    public BigDecimal getStatsPercentageForCurrentWeek(UUID userId) {
        List<Stats> weekStats = getStatsForCurrentWeek(userId);
        if (weekStats.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalScore = BigDecimal.ZERO;
        for (Stats stats : weekStats) {
            totalScore = totalScore.add(stats.getScore());
        }

        BigDecimal averageScore = totalScore.divide(BigDecimal.valueOf(weekStats.size()), 2, BigDecimal.ROUND_HALF_UP);
        return averageScore.multiply(BigDecimal.valueOf(100));
    }



     public List<Stats> getStatsForCurrentMonth(UUID userId) {
        LocalDate currentDate = LocalDate.now();
        LocalDate monthStartDate = currentDate.withDayOfMonth(1);
        return statsRepository.findByUserIdAndDateBetween(userId, monthStartDate, currentDate);
    }


    @SuppressWarnings("deprecation")
    public BigDecimal getStatsPercentageForCurrentMonth(UUID userId) {
        List<Stats> monthStats = getStatsForCurrentMonth(userId);
        if (monthStats.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalScore = BigDecimal.ZERO;
        for (Stats stats : monthStats) {
            totalScore = totalScore.add(stats.getScore());
        }

        BigDecimal averageScore = totalScore.divide(BigDecimal.valueOf(monthStats.size()), 2, BigDecimal.ROUND_HALF_UP);
        return averageScore.multiply(BigDecimal.valueOf(100));
    }


    @SuppressWarnings("deprecation")
    public BigDecimal getStatsPercentageForEntireHistory(UUID userId) {
        List<Stats> allStats = statsRepository.findByUserId(userId);
        if (allStats.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalScore = BigDecimal.ZERO;
        for (Stats stats : allStats) {
            totalScore = totalScore.add(stats.getScore());
        }

        BigDecimal averageScore = totalScore.divide(BigDecimal.valueOf(allStats.size()), 2, BigDecimal.ROUND_HALF_UP);
        return averageScore.multiply(BigDecimal.valueOf(100));
    }


    public Stats addStat(UUID userId, BigDecimal score, BigDecimal tasksCompleted, BigDecimal timeManagement,
    boolean reportCompleted, BigDecimal productivity, boolean accessible) {
        Stats stat = new Stats();
        stat.setUser_id(userId);
        stat.setDate(LocalDate.now());
        stat.setScore(score);
        stat.setTasks_completed(tasksCompleted);
        stat.setTime_management(timeManagement);
        stat.setReport_completed(reportCompleted);
        stat.setProductivity(productivity);
        stat.setAccessible(accessible);
        return statsRepository.save(stat);
}



}