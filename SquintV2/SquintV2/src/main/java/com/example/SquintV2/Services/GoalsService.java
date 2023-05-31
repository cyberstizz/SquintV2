package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Repositories.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Goals> getGoalById(UUID goalId) {
        return goalsRepository.findById(goalId);
    }


    public List<Goals> getGoalsForUserAndDay(UUID userId, LocalDate day) {
        List<Goals> userGoals = goalsRepository.findByUserId(userId);
        List<Goals> goalsForDay = new ArrayList<>();
    
        for (Goals goal : userGoals) {
            if (goal.getStartDate().equals(day)) {
                goalsForDay.add(goal);
            }
        }
    
        return goalsForDay;
    }

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