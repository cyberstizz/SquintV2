import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SquintV2.Models.Stats;
import com.example.SquintV2.Services.StatsService;

import java.math.BigDecimal;
import java.util.List;
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


    @PostMapping("/add")
    public ResponseEntity<Stats> addStat(@RequestBody StatsRequest request) {
        Stats newStat = statsService.addStat(request.getUserId(), request.getScore(), request.getTasksCompleted(),
                request.getTimeManagement(), request.isReportCompleted(), request.getProductivity(),
                request.isAccessible());
        return ResponseEntity.status(HttpStatus.CREATED).body(newStat);
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


     // Inner class for the request body of the addStat method
     private static class StatsRequest {
        private UUID userId;
        private BigDecimal score;
        private BigDecimal tasksCompleted;
        private BigDecimal timeManagement;
        private boolean reportCompleted;
        private BigDecimal productivity;
        private boolean accessible;

        // Getters and setters

        public UUID getUserId() {
            return userId;
        }

        public void setUserId(UUID userId) {
            this.userId = userId;
        }

        public BigDecimal getScore() {
            return score;
        }

        public void setScore(BigDecimal score) {
            this.score = score;
        }

        public BigDecimal getTasksCompleted() {
            return tasksCompleted;
        }

        public void setTasksCompleted(BigDecimal tasksCompleted) {
            this.tasksCompleted = tasksCompleted;
        }

        public BigDecimal getTimeManagement() {
            return timeManagement;
        }

        public void setTimeManagement(BigDecimal timeManagement) {
            this.timeManagement = timeManagement;
        }

        public boolean isReportCompleted() {
            return reportCompleted;
        }

        public void setReportCompleted(boolean reportCompleted) {
            this.reportCompleted = reportCompleted;
        }

        public BigDecimal getProductivity() {
            return productivity;
        }

        public void setProductivity(BigDecimal productivity) {
            this.productivity = productivity;
        }

        public boolean isAccessible() {
            return accessible;
        }

        public void setAccessible(boolean accessible) {
            this.accessible = accessible;
        }
    }

}