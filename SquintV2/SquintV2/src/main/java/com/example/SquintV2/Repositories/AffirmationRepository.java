package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Affirmation;

public interface AffirmationRepository extends CrudRepository<Affirmation, Integer> {
    
}