package com.example.SquintV2.Controllers;

import com.example.SquintV2.Models.Goals;
import com.example.SquintV2.Services.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/goals")
public class GoalsController {

    private final GoalsService goalsService;


    @Autowired
    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Goals>> getAllGoalsForUser(@PathVariable UUID userId) {
        List<Goals> goals = goalsService.getAllGoalsForUser(userId);
        if (!goals.isEmpty()) {
            return ResponseEntity.ok(goals);
        } else {
            return ResponseEntity.noContent().build();
        }

    }


        @GetMapping("/{goalId}")
    public ResponseEntity<Goals> getGoalById(@PathVariable UUID goalId) {
        return goalsService.getGoalById(goalId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Goals> createGoal(@RequestBody Goals goal) {
        Goals createdGoal = goalsService.createGoal(goal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGoal);
    }


    @PutMapping
    public ResponseEntity<Goals> updateGoal(@RequestBody Goals updatedGoal) {
        Goals updated = goalsService.updateGoal(updatedGoal);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{goalId}")
    public ResponseEntity<Void> deleteGoal(@PathVariable UUID goalId) {
        goalsService.deleteGoal(goalId);
        return ResponseEntity.noContent().build();
    }



}