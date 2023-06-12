import main.java.com.example.SquintV2.Models.Books;
import main.java.com.example.SquintV2.Repositories.PhotoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class VisionBoardService {
    private final PhotoRepository photoRepository;

    @Autowired
    public VisionboardService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
}