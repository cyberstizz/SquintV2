package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/goals")
public class GoalsController {

    private final GoalService goalService;


    @Autowired
    public GoalsController(GoalService goalService) {
        this.goalService = goalService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Goals>> getAllGoalsForUser(@PathVariable UUID userId) {
        List<Goals> goals = goalService.getAllGoalsForUser(userId);
        if (!goals.isEmpty()) {
            return ResponseEntity.ok(goals);
        } else {
            return ResponseEntity.noContent().build();
        }

        
    }

}