package com.example.SquintV2.Controllers;


import com.example.SquintV2.Models.Photo;
import com.example.SquintV2.Services.VisionBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/visionboard")
public class VisionBoardController {

    private final VisionBoardService visionboardService;

    @Autowired
    public VisionBoardController(VisionBoardService visionboardService) {
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


    @PutMapping("/update/{photoId}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable UUID photoId, @RequestBody Photo updatedPhoto) {
        Photo photo = visionboardService.updatePhoto(photoId, updatedPhoto);
        return ResponseEntity.ok(photo);
    }


    @DeleteMapping("/delete/{photoId}")
    public ResponseEntity<?> deletePhoto(@PathVariable UUID photoId) {
        visionboardService.deletePhoto(photoId);
        return ResponseEntity.noContent().build();
    }
}