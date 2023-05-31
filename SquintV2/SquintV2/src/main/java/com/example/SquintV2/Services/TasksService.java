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

    public Tasks createTasks(Tasks tasks) {
        // Set any necessary attributes for the tasks
        // tasks.set...

        return tasksRepository.save(tasks);
    }

    public Tasks updateTasks(UUID tasksId, Tasks updatedTasks) {
        Tasks existingTasks = tasksRepository.findById(tasksId)
                .orElseThrow(() -> new RuntimeException("Tasks not found: " + tasksId));

        // Update the individual attributes of existingTasks using updatedTasks
        // existingTasks.set...

        return tasksRepository.save(existingTasks);
    }



}