package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Goal;

public interface GoalRepository extends CrudRepository<Goal, Integer> {
    
}