package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.DailySchedule;

public interface DailyScheduleRepository extends CrudRepository<DailySchedule, Integer> {
    
}