package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Goals;
import main.java.com.example.SquintV2.Models.Task;
import main.java.com.example.SquintV2.Services.GoalsService;
import main.java.com.example.SquintV2.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;


@Controller
public class SquintController {

    private final TaskService taskService;
    private final GoalsService goalsService;

    @Autowired
    public SquintController(TaskService taskService, GoalsService goalsService) {
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
}

