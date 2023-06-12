package main.java.com.example.SquintV2.Services;


import main.java.com.example.SquintV2.Models.Photo;
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
    public VisionBoardService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo getNextPhoto(UUID userId) {
        return photoRepository.findTopByUserIdOrderByDeadlineAsc(userId);
    }

    public Photo addPhoto(Photo photo) {
        return photoRepository.save(photo);
    }


    public Photo updatePhoto(UUID photoId, Photo updatedPhoto) {
        Photo existingPhoto = photoRepository.findById(photoId)
                .orElseThrow(() -> new RuntimeException("Photo not found: " + photoId));

        existingPhoto.setPath_or_url(updatedPhoto.getPath_or_url());
        existingPhoto.setDeadline(updatedPhoto.getDeadline());
        existingPhoto.setGoal_id(updatedPhoto.getGoal_id());

        return photoRepository.save(existingPhoto);
    }


    public void deletePhoto(UUID photoId) {
        photoRepository.deleteById(photoId);
    }

}