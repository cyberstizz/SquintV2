package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Friendship;
import main.java.com.example.SquintV2.Services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/friendship")
public class FriendshipController {

    private final FriendshipService friendshipService;

    @Autowired
    public FriendshipController(FriendshipService friendshipService) {
        this.friendshipService = friendshipService;
    }


    @GetMapping("/dashboard")
    public List<Friendship> showDashboard(@RequestParam UUID userId) {
        return friendshipService.getAllFriends(userId);
    }


    @PostMapping("/remove")
    public void removeFriend(@RequestParam UUID userId, @RequestParam UUID friendId) {
        friendshipService.removeFriend(userId, friendId);
    }

}