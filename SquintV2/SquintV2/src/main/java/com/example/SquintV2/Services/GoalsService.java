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


}