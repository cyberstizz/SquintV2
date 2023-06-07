package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Models.Tasks;
import main.java.com.example.SquintV2.Services.GoalsService;
import main.java.com.example.SquintV2.Services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SquintController {

    private final TasksService taskService;
    private final GoalsService goalsService;

    @Autowired
    public SquintController(TasksService taskService, GoalsService goalsService) {
        this.taskService = taskService;
        this.goalsService = goalsService;
    }


    @GetMapping("/dashboard")
    public String showSquintDashboard(Model model) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Fetch tasks for the current day
        List<Task> tasks = taskService.getTasksForDay(currentDate);

        // Fetch goals for the current day
        List<Goals> goals = goalsService.getGoalsForDay(currentDate);

        // Add tasks and goals to the model
        model.addAttribute("tasks", tasks);
        model.addAttribute("goals", goals);

        return "dashboard";
    }

    @GetMapping("/tasks-and-goals/day")
    public ResponseEntity<?> getTasksAndGoalsForDay() {
        LocalDate currentDate = LocalDate.now();
        List<Task> tasks = taskService.getTasksForDay(currentDate);
        List<Goals> goals = goalsService.getGoalsForDay(currentDate);

        Map<String, Object> response = new HashMap<>();
        response.put("tasks", tasks);
        response.put("goals", goals);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }    


    @GetMapping("/tasks-and-goals/week")
    public ResponseEntity<?> getTasksAndGoalsForWeek() {
        // Logic to fetch tasks and goals for the current week
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        List<Task> tasks = taskService.getTasksForWeek(startOfWeek, endOfWeek);
        List<Goals> goals = goalsService.getGoalsForWeek(startOfWeek, endOfWeek);

        Map<String, Object> response = new HashMap<>();
        response.put("tasks", tasks);
        response.put("goals", goals);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }




    @GetMapping("/tasks-and-goals/month")
    public ResponseEntity<?> getTasksAndGoalsForMonth() {
        // Logic to fetch tasks and goals for the current month
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfMonth = currentDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endOfMonth = currentDate.with(TemporalAdjusters.lastDayOfMonth());
        List<Task> tasks = taskService.getTasksForMonth(startOfMonth, endOfMonth);
        List<Goals> goals = goalsService.getGoalsForMonth(startOfMonth, endOfMonth);

        Map<String, Object> response = new HashMap<>();
        response.put("tasks", tasks);
        response.put("goals", goals);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("dashboard/update-task")
    public ResponseEntity<?> updateTasks(UUID tasksId, Tasks updatedTasks){

        TaskService.updateTasks

    }
}

