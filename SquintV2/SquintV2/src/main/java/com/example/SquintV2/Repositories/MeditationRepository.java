package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Meditation;

public interface MeditationRepository extends CrudRepository<Meditation, Integer> {
    
}