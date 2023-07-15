package com.example.SquintV2.Controllers;

import com.example.SquintV2.Models.Friendship;
import com.example.SquintV2.Services.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
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


    @PostMapping("/send-request")
    public void sendFriendRequest(@RequestParam UUID userId, @RequestParam UUID friendId) {
        friendshipService.sendFriendRequest(userId, friendId);
    }


    @PostMapping("/accept-request")
    public void acceptFriendRequest(@RequestParam UUID userId, @RequestParam UUID friendId) {
        friendshipService.acceptFriendRequest(userId, friendId);
    }


     @PostMapping("/block")
    public void blockUser(@RequestParam UUID userId, @RequestParam UUID friendId) {
        friendshipService.blockUser(userId, friendId);
    }

}