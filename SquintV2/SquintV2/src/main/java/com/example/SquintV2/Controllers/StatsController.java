import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;


@RestController
@RequestMapping("/stats")
public class StatsController {


    private final StatsService statsService;

    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }



    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<StatsDashboard> showDashboard(@PathVariable UUID userId) {
        StatsDashboard dashboard = new StatsDashboard();
        dashboard.setCurrentDayStats(statsService.getStatsForCurrentDay(userId).orElse(null));
        dashboard.setCurrentWeekStats(statsService.getStatsForCurrentWeek(userId));
        dashboard.setCurrentMonthStats(statsService.getStatsForCurrentMonth(userId));
        dashboard.setTotalScore(statsService.getStatsPercentageForEntireHistory(userId));
        return ResponseEntity.ok(dashboard);
    }



    // Inner class for the StatsDashboard response
    private static class StatsDashboard {
        private Stats currentDayStats;
        private List<Stats> currentWeekStats;
        private List<Stats> currentMonthStats;
        private BigDecimal totalScore;

        // Getters and setters

        public Stats getCurrentDayStats() {
            return currentDayStats;
        }

        public void setCurrentDayStats(Stats currentDayStats) {
            this.currentDayStats = currentDayStats;
        }

        public List<Stats> getCurrentWeekStats() {
            return currentWeekStats;
        }

        public void setCurrentWeekStats(List<Stats> currentWeekStats) {
            this.currentWeekStats = currentWeekStats;
        }

        public List<Stats> getCurrentMonthStats() {
            return currentMonthStats;
        }

        public void setCurrentMonthStats(List<Stats> currentMonthStats) {
            this.currentMonthStats = currentMonthStats;
        }

        public BigDecimal getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(BigDecimal totalScore) {
            this.totalScore = totalScore;
        }
    }

}