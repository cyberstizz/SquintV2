package main.java.com.example.SquintV2.Services;

import com.example.SquintV2.Models.Tasks;
import com.example.SquintV2.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class TasksService {

        private final TasksRepository tasksrepository;

        @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public Tasks getTasksById(UUID tasksId) {
        return tasksRepository.findById(tasksId)
                .orElseThrow(() -> new RuntimeException("Tasks not found: " + tasksId));
    }



}