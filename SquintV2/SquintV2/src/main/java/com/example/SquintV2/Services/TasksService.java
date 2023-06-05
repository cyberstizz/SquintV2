package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Tasks;
import main.java.com.example.SquintV2.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<Tasks> getTasksForUserAndDay(UUID userId, LocalDate day) {
        List<Tasks> userTasks = tasksRepository.findByUserId(userId);
        List<Tasks> tasksForDay = new ArrayList<>();
    
        for (Tasks task : userTasks) {
            if (task.getTask_deadline().equals(day)) {
                tasksForDay.add(task);
            }
        }
    
        return tasksForDay;
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

    public void deleteTasks(UUID tasksId) {
        tasksRepository.deleteById(tasksId);
    }



}