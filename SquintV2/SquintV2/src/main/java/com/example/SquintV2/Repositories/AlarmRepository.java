package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Alarm;

public interface AlarmRepository extends CrudRepository<Alarm, Integer> {
    
}