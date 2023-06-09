package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Tasks;
import main.java.com.example.SquintV2.Repositories.AffirmationRepository;
import main.java.com.example.SquintV2.Repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class AffirmationsService {

    private final AffirmationRepository affirmationRepository;
}