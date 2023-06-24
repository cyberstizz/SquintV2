package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Repositories.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class GoalsService {


    private final GoalsRepository goalsRepository;

    @Autowired
    public GoalsService(GoalsRepository goalsRepository) {
        this.goalsRepository = goalsRepository;
    }

    public List<Goals> getAllGoalsForUser(UUID user_Id) {
        return goalsRepository.findAllByUserId(user_Id);
    }


    public List<Goals> findGoalsForUserInTimeRange(UUID user_id, LocalDate start, LocalDate end) {
        return goalsRepository.findByUser_idAndGoal_deadlineBetween(user_id, start, end);
    }

    public Optional<Goals> getGoalById(UUID goalId) {
        return goalsRepository.findById(goalId);
    }


    // public List<Goals> getGoalsForUserAndDay(UUID userId, LocalDate day) {
    //     List<Goals> userGoals = goalsRepository.findAllByUserId(userId);
    //     List<Goals> goalsForDay = new ArrayList<>();
    
    //     for (Goals goal : userGoals) {
    //         if (goal.getGoal_deadline().equals(day)) {
    //             goalsForDay.add(goal);
    //         }
    //     }
    
    //     return goalsForDay;
    // }


    // public List<Goals> getGoalsForUserAndWeek(UUID userId, LocalDate currentDate) {
    //     LocalDate startOfWeek = currentDate.with(DayOfWeek.MONDAY);
    //     LocalDate endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);

    //     List<Goals> userGoals = goalsRepository.findAllByUserId(userId);
    //     List<Goals> goalsForWeek = new ArrayList<>();

    //     for (Goals goal : userGoals) {
    //         LocalDate goalDeadline = goal.getGoal_deadline();
    //         if (!goalDeadline.isBefore(startOfWeek) && !goalDeadline.isAfter(endOfWeek)) {
    //             goalsForWeek.add(goal);
    //         }
    //     }

    //     return goalsForWeek;
    // }


    // public List<Goals> getGoalsForUserAndMonth(UUID userId, LocalDate currentDate) {
    //     LocalDate startOfMonth = currentDate.withDayOfMonth(1);
    //     LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

    //     List<Goals> userGoals = goalsRepository.findAllByUserId(userId);
    //     List<Goals> goalsForMonth = new ArrayList<>();

    //     for (Goals goal : userGoals) {
    //         LocalDate goalDeadline = goal.getGoal_deadline();
    //         if (!goalDeadline.isBefore(startOfMonth) && !goalDeadline.isAfter(endOfMonth)) {
    //             goalsForMonth.add(goal);
    //         }
    //     }

    //     return goalsForMonth;
    // }

    

    public Goals createGoal(Goals goal) {
        return goalsRepository.save(goal);
    }

    public Goals updateGoal(Goals updatedGoal) {
        return goalsRepository.save(updatedGoal);
    }

    public void deleteGoal(UUID goalId) {
        goalsRepository.deleteById(goalId);
    }
    

}