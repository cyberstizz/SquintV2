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


    @GetMapping("/dashboard/week")
    public String showTasksAndGoalsForWeek(Model model) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Fetch tasks for the current week
        List<Task> tasks = taskService.getTasksForUserAndWeek(currentDate);

        // Fetch goals for the current week
        List<Goals> goals = goalsService.getGoalsForUserAndWeek(currentDate);

        // Add tasks and goals to the model
        model.addAttribute("tasks", tasks);
        model.addAttribute("goals", goals);

        return "dashboard";
    }

    @GetMapping("/dashboard/month")
    public String showTasksAndGoalsForMonth(Model model) {
        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Fetch tasks for the current month
        List<Task> tasks = taskService.getTasksForUserAndMonth(currentDate);

        // Fetch goals for the current month
        List<Goals> goals = goalsService.getGoalsForUserAndMonth(currentDate);

        // Add tasks and goals to the model
        model.addAttribute("tasks", tasks);
        model.addAttribute("goals", goals);

        return "dashboard";
    }
}

