package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Goals;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Repository
public interface GoalsRepository extends CassandraRepository<Goals, UUID>{
    List<Goals> findAllByUserId(UUID userId);
    List<Goals> getGoalsForDay(UUID currentDate);
    List<Goals> findByUser_idAndGoal_deadlineBetween(UUID user_id, LocalDate start, LocalDate end);


}

