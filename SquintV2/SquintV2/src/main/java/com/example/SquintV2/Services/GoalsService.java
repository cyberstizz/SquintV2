package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Repositories.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class GoalService {


    private final GoalsRepository goalsRepository;

    @Autowired
    public GoalService(GoalsRepository goalsRepository) {
        this.goalsRepository = goalsRepository;
    }

    public List<Goals> getAllGoalsForUser(UUID userId) {
        return goalsRepository.findAllByUserId(userId);
    }

    public Optional<Goals> getGoalById(UUID goalId) {
        return goalsRepository.findById(goalId);
    }

    public Goals createGoal(Goals goal) {
        return goalsRepository.save(goal);
    }

    public Goals updateGoal(Goals updatedGoal) {
        return goalsRepository.save(updatedGoal);
    }


}