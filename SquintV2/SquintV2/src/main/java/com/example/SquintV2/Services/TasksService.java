package com.example.SquintV2.Services;

import com.example.SquintV2.Models.Tasks;
import com.example.SquintV2.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;



@Service
public class TasksService {

        private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public List<Tasks> findTasksForUserInTimeRange(UUID user_id, LocalDate start, LocalDate end) {
        return tasksRepository.findByUser_idAndTask_deadlineBetween(user_id, start, end);
    }

    public Tasks getTasksById(UUID tasksId) {
        return tasksRepository.findById(tasksId)
                .orElseThrow(() -> new RuntimeException("Tasks not found: " + tasksId));
    }

    // public List<Tasks> getTasksForUserAndDay(UUID userId, LocalDate day) {
    //     List<Tasks> userTasks = tasksRepository.findByUserId(userId);
    //     List<Tasks> tasksForDay = new ArrayList<>();
    
    //     for (Tasks task : userTasks) {
    //         if (task.getTask_deadline().equals(day)) {
    //             tasksForDay.add(task);
    //         }
    //     }
    
    //     return tasksForDay;
    // }


    // public List<Tasks> getTasksForUserAndWeek(UUID userId, LocalDate currentDate) {
    //     LocalDate startOfWeek = currentDate.with(DayOfWeek.MONDAY);
    //     LocalDate endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);

    //     List<Tasks> userTasks = tasksRepository.findByUserId(userId);
    //     List<Tasks> tasksForWeek = new ArrayList<>();

    //     for (Tasks task : userTasks) {
    //         LocalDate taskDeadline = task.getTask_deadline();
    //         if (!taskDeadline.isBefore(startOfWeek) && !taskDeadline.isAfter(endOfWeek)) {
    //             tasksForWeek.add(task);
    //         }
    //     }

    //     return tasksForWeek;
    // }


    // public List<Tasks> getTasksForUserAndMonth(UUID userId, LocalDate currentDate) {
    //     LocalDate startOfMonth = currentDate.withDayOfMonth(1);
    //     LocalDate endOfMonth = startOfMonth.withDayOfMonth(startOfMonth.lengthOfMonth());

    //     List<Tasks> userTasks = tasksRepository.findByUserId(userId);
    //     List<Tasks> tasksForMonth = new ArrayList<>();

    //     for (Tasks task : userTasks) {
    //         LocalDate taskDeadline = task.getTask_deadline();
    //         if (!taskDeadline.isBefore(startOfMonth) && !taskDeadline.isAfter(endOfMonth)) {
    //             tasksForMonth.add(task);
    //         }
    //     }

    //     return tasksForMonth;
    // }

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

    public void deleteTask(UUID tasksId) {
        tasksRepository.deleteById(tasksId);
    }



}