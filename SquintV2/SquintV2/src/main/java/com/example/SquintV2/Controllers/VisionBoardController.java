import main.java.com.example.SquintV2.Models.Photo;
import main.java.com.example.SquintV2.Services.VisionBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/visionboard")
public class VisionBoardController {

    private final VisionboardService visionboardService;

    @Autowired
    public VisionboardController(VisionboardService visionboardService) {
        this.visionboardService = visionboardService;
    }


    @GetMapping("/next/{userId}")
    public ResponseEntity<Photo> getNextPhoto(@PathVariable UUID userId) {
        Photo nextPhoto = visionboardService.getNextPhoto(userId);
        return ResponseEntity.ok(nextPhoto);
    }


    @PostMapping("/add")
    public ResponseEntity<Photo> addPhoto(@RequestBody Photo photo) {
        Photo addedPhoto = visionboardService.addPhoto(photo);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPhoto);
    }
}