package com.example.SquintV2.Controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.example.SquintV2.Models.Goals;
import com.example.SquintV2.Models.Tasks;
import com.example.SquintV2.Services.GoalsService;
import com.example.SquintV2.Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class SquintController {

    private final TasksService taskService;
    private final GoalsService goalsService;

    @Autowired
    public SquintController(TasksService taskService, GoalsService goalsService) {
        this.taskService = taskService;
        this.goalsService = goalsService;
    }


    @GetMapping("/combinedSchedule")
public List<Object> getCombinedSchedule(UUID user_id, LocalDate start, LocalDate end) {
    List<Tasks> tasks = taskService.findTasksForUserInTimeRange(user_id, start, end);
    List<Goals> goals = goalsService.findGoalsForUserInTimeRange(user_id, start, end);
    
    List<Object> combined = new ArrayList<>();
    combined.addAll(tasks);
    combined.addAll(goals);
    
    combined.sort((o1, o2) -> {
        LocalDate date1, date2;
        if (o1 instanceof Tasks) {
            date1 = ((Tasks) o1).getTask_deadline();
        } else {
            date1 = ((Goals) o1).getGoal_deadline();
        }
        if (o2 instanceof Tasks) {
            date2 = ((Tasks) o2).getTask_deadline();
        } else {
            date2 = ((Goals) o2).getGoal_deadline();
        }
        return date1.compareTo(date2);
    });
    
    return combined;
}


 
    // @GetMapping("/tasks-and-goals/day/{userId}")
    // public ResponseEntity<?> getTasksAndGoalsForDay(@PathVariable UUID userId) {
    //     LocalDate currentDate = LocalDate.now();
    //     List<Tasks> tasks = taskService.getTasksForUserAndDay(userId, currentDate);
    //     List<Goals> goals = goalsService.getGoalsForUserAndDay(userId, currentDate);

    //     Map<String, Object> response = new HashMap<>();
    //     response.put("tasks", tasks);
    //     response.put("goals", goals);

    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }    


    // @GetMapping("/tasks-and-goals/week/{userId}")
    // public ResponseEntity<?> getTasksAndGoalsForWeek(@PathVariable UUID userId) {
    //     // Logic to fetch tasks and goals for the current week
    //     LocalDate currentDate = LocalDate.now();

    //     List<Tasks> tasks = taskService.getTasksForUserAndWeek(userId, currentDate);
    //     List<Goals> goals = goalsService.getGoalsForUserAndWeek(userId, currentDate);

    //     Map<String, Object> response = new HashMap<>();
    //     response.put("tasks", tasks);
    //     response.put("goals", goals);

    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }




    // @GetMapping("/tasks-and-goals/month/{userId}")
    // public ResponseEntity<?> getTasksAndGoalsForMonth(@PathVariable UUID userId) {
    //     // Logic to fetch tasks and goals for the current month
    //     LocalDate currentDate = LocalDate.now();
    //     List<Tasks> tasks = taskService.getTasksForUserAndMonth(userId, currentDate);
    //     List<Goals> goals = goalsService.getGoalsForUserAndMonth(userId, currentDate);

    //     Map<String, Object> response = new HashMap<>();
    //     response.put("tasks", tasks);
    //     response.put("goals", goals);

    //     return new ResponseEntity<>(response, HttpStatus.OK);
    // }

    @PutMapping("/{taskId}")
    public ResponseEntity<?> updateTasks(@PathVariable UUID taskId, @RequestBody Tasks updatedTask) {

        Tasks task = taskService.getTasksById(taskId);


        // Update the task attributes based on the updatedTask object
        task.setTask_name(updatedTask.getTask_name());
        task.setTask_description(updatedTask.getTask_description());
        task.setTask_deadline(updatedTask.getTask_deadline());


         // Set other attributes as needed

         Tasks savedTask = taskService.updateTasks(taskId, task);
         return new ResponseEntity<>(savedTask, HttpStatus.OK);

    }


    @PostMapping("/{taskId}")
    public ResponseEntity<?> createTasks(@PathVariable Tasks newTask) {
        Tasks createdTask = taskService.createTasks(newTask);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }



    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> createGoal(@RequestBody Goals newGoal) {
        Goals createdGoal = goalsService.createGoal(newGoal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }


    @DeleteMapping("/{goalId}")
    public ResponseEntity<?> deleteGoal(@PathVariable UUID goalId) {
        goalsService.deleteGoal(goalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





    @PutMapping("/{goalId}")
    public ResponseEntity<?> updateGoalById(@PathVariable UUID goalId, @RequestBody Goals updatedGoal) {
        Goals existingGoal = goalsService.getGoalById(goalId).orElseThrow(() -> new RuntimeException("Goal not found: " + goalId));
        existingGoal.setGoal_name(updatedGoal.getGoal_name());
        existingGoal.setGoal_description(updatedGoal.getGoal_description());
        existingGoal.setGoal_deadline(updatedGoal.getGoal_deadline());

        Goals updatedGoalEntity = goalsService.updateGoal(existingGoal);
        return new ResponseEntity<>(updatedGoalEntity, HttpStatus.OK);
    }

}

