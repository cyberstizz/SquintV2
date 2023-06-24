package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Tasks;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Repository
public interface TasksRepository extends CassandraRepository<Tasks, UUID>{
    List<Tasks> getTasksForDay(UUID currentDate);
    Tasks findByUserId(UUID userId);
    List<Tasks> findByUser_idAndTask_deadlineBetween(UUID user_id, LocalDate start, LocalDate end);


}

